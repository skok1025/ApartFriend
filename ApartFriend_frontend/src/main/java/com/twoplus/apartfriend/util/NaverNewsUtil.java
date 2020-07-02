package com.twoplus.apartfriend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class NaverNewsUtil {
	private static String CLIENT_ID = "X4MuqyooqklYGPvKdgL3";
	private static String CLIENT_PASSWORD = "VGLNtXWpZC";

	public static String response(String newsSearchKeyword) {
		String result = "";
		String text = null;
		try {
			text = URLEncoder.encode(newsSearchKeyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/news.xml?query=" + text + "&start=1&sort=sim"; // json 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
		requestHeaders.put("X-Naver-Client-Secret", CLIENT_PASSWORD);
		String responseBody = get(apiURL, requestHeaders);
		
		try {
			Element element = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource inputSouce = new InputSource();
			inputSouce.setCharacterStream(new StringReader(responseBody));
			Document document = builder.parse(inputSouce);
			NodeList nodelist = document.getElementsByTagName("item");
			result = "<div class='container'>";
			for (int i = 0; i < nodelist.getLength(); i ++) {
				
				Element titleE = (Element) nodelist.item(i).getChildNodes().item(0);
				Element linkE = (Element) nodelist.item(i).getChildNodes().item(2);
				Element pubE = (Element) nodelist.item(i).getChildNodes().item(4);
				
				
				result += "<a href='"+linkE.getTextContent()+"'>"+titleE.getTextContent()+"</a><hr/>";
				
			}
			result += "</div>";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
}
