package com.postmen.javasdk.handler;

import java.io.IOException;
import com.google.api.client.util.BackOff;

public class ExpBackOff implements BackOff {

	private long delayTime;
	
	public ExpBackOff() {
		delayTime = 1000;
	}
	/*
	public ExpBackOff(Integer numRetries, Integer retriesLeft) {
		computeDelayTime(numRetries, retriesLeft);
	}
	*/
	
	public void reset() throws IOException {
			// TODO Auto-generated method stub
		delayTime = 1000;
	}

	public long nextBackOffMillis() throws IOException {
		// TODO Auto-generated method stub
		long delay = delayTime;
		delayTime *= 2;
		return delay;
	}
	/*
	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}
	
	public void computeDelayTime(int numRetries, int retriesLeft) {
		int pow = numRetries - retriesLeft;
		this.delayTime = (long) Math.pow(2, pow) * 1000;
	}
	*/
}
