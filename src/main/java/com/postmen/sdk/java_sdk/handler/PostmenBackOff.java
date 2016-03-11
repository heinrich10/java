package com.postmen.sdk.java_sdk.handler;

import java.io.IOException;

import com.google.api.client.util.BackOff;

public class PostmenBackOff implements BackOff {

	private long delayTime;
	
	public PostmenBackOff(long delayTime) {
		if(delayTime < 0) {
			this.delayTime = 0;
		} else {
			this.delayTime = delayTime;
		}
		
	}
	
	public void reset() throws IOException {
			// TODO Auto-generated method stub
		delayTime = 0;
	}

	public long nextBackOffMillis() throws IOException {
		// TODO Auto-generated method stub
		return delayTime;
	}
	
	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}
		
}
