package com.postmen.sdk.java_sdk.handler;

import com.google.api.client.http.HttpHeaders;

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
	public void setRateLimit(HttpHeaders headers) {
		int rateCount = Integer.parseInt(headers.getFirstHeaderStringValue("X-RateLimit-Remaining"));
		// rateLimit = Integer.parseInt(headers.getFirstHeaderStringValue("X-RateLimit-Limit"));
		long resetTime = Long.parseLong(headers.getFirstHeaderStringValue("X-RateLimit-Reset"));
		this.rateCount = rateCount;
		this.resetTime = resetTime;
	}
}
