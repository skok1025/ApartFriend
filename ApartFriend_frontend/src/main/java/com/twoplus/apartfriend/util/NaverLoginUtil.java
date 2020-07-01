package com.twoplus.apartfriend.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import com.twoplus.apartfriend.dto.NaverLoginTokenDTO;
import com.twoplus.apartfriend.dto.NaverProfileDTO;

public class NaverLoginUtil {

	private static String CLIENT_ID = "7JnCYCwOSCKGblgo0LCT";
	private static String CLIENT_PASSWORD = "mBEVYzVEoK";

	public static String getLoginApiUrl(HttpSession session, String callbackUrl) {
		try {
			String redirectURI = URLEncoder.encode("http://localhost:8081/naverlogin/callback", "UTF-8");
			SecureRandom random = new SecureRandom();
			String state = new BigInteger(130, random).toString();
			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id=" + CLIENT_ID;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&state=" + state;
			session.setAttribute("state", state);
			return apiURL;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static NaverLoginTokenDTO getResponse(String code, String state, String callbackUrl) {
		NaverLoginTokenDTO resultToken = new NaverLoginTokenDTO();
		try {
			String redirectURI = URLEncoder.encode(callbackUrl, "UTF-8");
			String apiURL;
			apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
			apiURL += "client_id=" + CLIENT_ID;
			apiURL += "&client_secret=" + CLIENT_PASSWORD;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			String access_token = "";
			String refresh_token = "";
			System.out.println("apiURL=" + apiURL);

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				JSONObject jObject = new JSONObject(res.toString());
				resultToken.setAccess_token(jObject.getString("access_token"));
				resultToken.setRefresh_token(jObject.getString("refresh_token"));

				return resultToken;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* 네이버 프로필 읽어오기 */
	public static NaverProfileDTO getProfile(NaverLoginTokenDTO naverLoginTokenDTO) {
		NaverProfileDTO result=  new NaverProfileDTO();
		String token = naverLoginTokenDTO.getAccess_token();
		String header = "Bearer " + token;

		String apiURL = "https://openapi.naver.com/v1/nid/me";

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);
		
		JSONObject jObject = new JSONObject(responseBody);
		JSONObject responseJObject = jObject.getJSONObject("response");
		result.setResultcode(jObject.getString("resultcode"));
		result.setMessage(jObject.getString("message"));
		result.setNickname(responseJObject.getString("nickname"));
		result.setGender(responseJObject.getString("gender"));
		result.setEmail(responseJObject.getString("email"));
		result.setName(convertString(responseJObject.getString("name")));
		
		return result;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	// 유니코드에서 String으로 변환
	public static String convertString(String val) {
		// 변환할 문자를 저장할 버퍼 선언
		StringBuffer sb = new StringBuffer();
		// 글자를 하나하나 탐색한다.
		for (int i = 0; i < val.length(); i++) {
			if ('\\' == val.charAt(i) && 'u' == val.charAt(i + 1)) {
				// 그 뒤 네글자는 유니코드의 16진수 코드이다. int형으로 바꾸어서 다시 char 타입으로 강제 변환한다.
				Character r = (char) Integer.parseInt(val.substring(i + 2, i + 6), 16);
				// 변환된 글자를 버퍼에 넣는다.
				sb.append(r);
				// for의 증가 값 1과 5를 합해 6글자를 점프
				i += 5;
			} else {
				// ascii코드면 그대로 버퍼에 넣는다.
				sb.append(val.charAt(i));
			}
		}
		// 결과 리턴
		return sb.toString();
	}

	/* 네이버 프로필 읽어오기 */

}
