package com.twoplus.apartfriend.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SMSCafe24Service {

	/**
	 * nullcheck
	 * 
	 * @param str,
	 *            Defaultvalue
	 * @return
	 */
	public static String nullcheck(String str, String Defaultvalue) throws Exception {
		String ReturnDefault = "";
		if (str == null) {
			ReturnDefault = Defaultvalue;
		} else if (str == "") {
			ReturnDefault = Defaultvalue;
		} else {
			ReturnDefault = str;
		}
		return ReturnDefault;
	}

	/**
	 * BASE64 Encoder
	 * 
	 * @param str
	 * @return
	 */
	public static String base64Encode(String str) throws java.io.IOException {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		byte[] strByte = str.getBytes();
		String result = encoder.encode(strByte);
		return result;
	}

	/**
	 * BASE64 Decoder
	 * 
	 * @param str
	 * @return
	 */
	public static String base64Decode(String str) throws java.io.IOException {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] strByte = decoder.decodeBuffer(str);
		String result = new String(strByte);
		return result;
	}

	public void cafe24SMSService(
    		String message,
    		String receiverTel,
    		String rDate,
    		String rTime,
    		String psmsType,
    		String psubject,
    		String ptestflag,
    		String pdestination,
    		String prepeatFlag,
    		String prepeatNum,
    		String prepeatTime) throws Exception {
    	String charsetType = "UTF-8"; //EUC-KR ?? UTF-8
    	String  action     = nullcheck("go", "");
        if(action.equals("go")) {
            String sms_url = "";
            sms_url = "https://sslsms.cafe24.com/sms_sender.php"; // SMS ? ?‘?μ²? URL
            String user_id = base64Encode("skok1025"); // SMS??΄?
            String secure = base64Encode("c6636c913e4042af7ea8a5bf52c06788");//?Έμ¦ν€
            String msg = base64Encode(nullcheck(message, ""));
            String rphone = base64Encode(nullcheck(receiverTel, "")); // λ°λ?¬? λ²νΈ
            String sphone1 = base64Encode(nullcheck("010", ""));
            String sphone2 = base64Encode(nullcheck("6866", ""));
            String sphone3 = base64Encode(nullcheck("9202", ""));
            String rdate = base64Encode(nullcheck(rDate, ""));
            String rtime = base64Encode(nullcheck(rTime, ""));
            String mode = base64Encode("1");
            String subject = "sms ? λͺ?";
            if(nullcheck(psmsType, "").equals("L")) {
                subject = base64Encode(nullcheck(psubject, ""));
            }
            String testflag = base64Encode(nullcheck(ptestflag, ""));
            String destination = base64Encode(nullcheck(pdestination, ""));
            String repeatFlag = base64Encode(nullcheck(prepeatFlag, ""));
            String repeatNum = base64Encode(nullcheck(prepeatNum, ""));
            String repeatTime = base64Encode(nullcheck(prepeatTime, ""));
      
            String nointeractive = nullcheck("1", "");
            String smsType = base64Encode(nullcheck("S", ""));
            String[] host_info = sms_url.split("/");
            String host = host_info[2];
            String path = "/" + host_info[3];
            int port = 80;
            // ?°?΄?° λ§΅ν λ³?? ? ?
            String arrKey[]
                = new String[] {"user_id","secure","msg", "rphone","sphone1","sphone2","sphone3","rdate","rtime"
                            ,"mode","testflag","destination","repeatFlag","repeatNum", "repeatTime", "smsType", "subject"};
            String valKey[]= new String[arrKey.length] ;
            valKey[0] = user_id;
            valKey[1] = secure;
            valKey[2] = msg;
            valKey[3] = rphone;
            valKey[4] = sphone1;
            valKey[5] = sphone2;
            valKey[6] = sphone3;
            valKey[7] = rdate;
            valKey[8] = rtime;
            valKey[9] = mode;
            valKey[10] = testflag;
            valKey[11] = destination;
            valKey[12] = repeatFlag;
            valKey[13] = repeatNum;
            valKey[14] = repeatTime;
            valKey[15] = smsType;
            valKey[16] = subject;
            String boundary = "";
            Random rnd = new Random();
            String rndKey = Integer.toString(rnd.nextInt(32000));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytData = rndKey.getBytes();
            md.update(bytData);
            byte[] digest = md.digest();
            for(int i =0;i<digest.length;i++)
            {
                boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
            }
            boundary = "---------------------"+boundary.substring(0,11);
            // λ³Έλ¬Έ ??±
            String data = "";
            String index = "";
            String value = "";
            for (int i=0;i<arrKey.length; i++)
            {
                index =  arrKey[i];
                value = valKey[i];
                data +="--"+boundary+"\r\n";
                data += "Content-Disposition: form-data; name=\""+index+"\"\r\n";
                data += "\r\n"+value+"\r\n";
                data +="--"+boundary+"\r\n";
            }
            //out.println(data);
            InetAddress addr = InetAddress.getByName(host);
            Socket socket = new Socket(host, port);
            // ?€? ? ?‘
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
            wr.write("POST "+path+" HTTP/1.0\r\n");
            wr.write("Content-Length: "+data.length()+"\r\n");
            wr.write("Content-type: multipart/form-data, boundary="+boundary+"\r\n");
            wr.write("\r\n");
            // ?°?΄?° ? ?‘
            wr.write(data);
            wr.flush();
            // κ²°κ³Όκ°? ?»κΈ?
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),charsetType));
            String line;
            String alert = "";
            ArrayList tmpArr = new ArrayList();
            while ((line = rd.readLine()) != null) {
                tmpArr.add(line);
            }
            wr.close();
            rd.close();
            String tmpMsg = (String)tmpArr.get(tmpArr.size()-1);
            String[] rMsg = tmpMsg.split(",");
            String Result= rMsg[0]; //λ°μ‘κ²°κ³Ό
            String Count= ""; //??¬κ±΄μ
            if(rMsg.length>1) {Count= rMsg[1]; }
                            //λ°μ‘κ²°κ³Ό ?λ¦?
            if(Result.equals("success")) {
                alert = "?±κ³΅μ ?Όλ‘? λ°μ‘????΅??€.";
                alert += " ??¬κ±΄μ? "+ Count+"κ±? ???€.";
            }
            else if(Result.equals("reserved")) {
                alert = "?±κ³΅μ ?Όλ‘? ??½???΅??€";
                alert += " ??¬κ±΄μ? "+ Count+"κ±? ???€.";
            }
            else if(Result.equals("3205")) {
                alert = "?λͺ»λ λ²νΈ?????€.";
            }
            else {
                alert = "[Error]"+Result;
            }
           
            System.out.println("======== cafe24 message Hosting service κ²°κ³Ό ==========");
            System.out.println("nointeractive: "+nointeractive);
            System.out.println(alert);
            if(nointeractive.equals("1") && !(Result.equals("Test Success!")) && !(Result.equals("success")) && !(Result.equals("reserved")) ) {
               System.out.println(alert);
            }
            else if(!(nointeractive.equals("1"))) {
                System.out.println(alert);
            }
            
            System.out.println("======== cafe24 message Hosting service κ²°κ³Ό ==========");
            
            //return "redirect:/"+redirectUrl+"?sendSuccess=yes";
    }
		//return "redirect:/"+redirectUrl+"?sendSuccess=no";
    }
	
}
