package com.twoplus.apartfriend.dto;

public class LogJSON {
	
	private String logTime;
	private Object logData;
	private LogType logType;
	
	public LogJSON(String logTime, Object logData, LogType logType) {
		super();
		this.logTime = logTime;
		this.logData = logData;
		this.logType = logType;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public Object getLogData() {
		return logData;
	}
	public void setLogData(Object logData) {
		this.logData = logData;
	}
	public LogType getLogType() {
		return logType;
	}
	public void setLogType(LogType logType) {
		this.logType = logType;
	}
	@Override
	public String toString() {
		return "LogJSON [logTime=" + logTime + ", logData=" + logData + ", logType=" + logType + "]";
	}
	
	

}
