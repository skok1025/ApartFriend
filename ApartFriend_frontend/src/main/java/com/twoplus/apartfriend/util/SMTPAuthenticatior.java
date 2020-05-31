package com.twoplus.apartfriend.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
 
public class SMTPAuthenticatior extends Authenticator{
 
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    	String naverId = "skok1025@naver.com";
    	String naverPw = "password";
        return new PasswordAuthentication(naverId, naverPw);
    }
}
