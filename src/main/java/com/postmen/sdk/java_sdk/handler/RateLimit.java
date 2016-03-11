package com.postmen.sdk.java_sdk.handler;

public class RateLimit {
	private int rateCount = 10;
	private long resetTime = 0;
	
	public int getRateCount() {
		return rateCount;
	}
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
	public long getResetTime() {
		return resetTime;
	}
	public void setResetTime(long resetTime) {
		this.resetTime = resetTime;
	}
	public void decrementRateCount() {
		if(rateCount >= 0) {
			rateCount--;
		}
	}
}
