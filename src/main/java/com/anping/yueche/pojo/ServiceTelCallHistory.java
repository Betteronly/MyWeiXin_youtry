package com.anping.yueche.pojo;

public class ServiceTelCallHistory {
	private String id;
	private String telFrom;
    private String telTo;
	private String callTime;
	private String count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelFrom() {
		return telFrom;
	}

	public void setTelFrom(String telFrom) {
		this.telFrom = telFrom;
	}

	public String getTelTo() {
		return telTo;
	}

	public void setTelTo(String telTo) {
		this.telTo = telTo;
	}

	public String getCallTime() {
		return callTime;
	}

	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}


	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
