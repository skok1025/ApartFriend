package com.twoplus.apartfriend.libarary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class libLog {
	public String basePath = "D:/apartfriend/";
	private static libLog libLog = new libLog();
	
	public static libLog getInstance() {
		return libLog;
	}
	
	public boolean write(String logKey, String logData) {
		String logPath = basePath + logKey;
		
		File file = new File(logPath);
        FileWriter writer = null;
        
        try {
            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
            writer = new FileWriter(file, true);
            writer.write(logData);
            writer.flush();
            
            System.out.println("DONE");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
                return true;
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return false;
       
	}
	
	
}
