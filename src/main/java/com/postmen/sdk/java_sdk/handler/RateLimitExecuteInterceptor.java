package com.postmen.sdk.java_sdk.handler;

import java.io.IOException;
import java.util.Calendar;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.util.Sleeper;

public class RateLimitExecuteInterceptor implements HttpExecuteInterceptor {
	
	private RateLimit rateLimit;
	private Sleeper sleeper;
	
	public RateLimitExecuteInterceptor(RateLimit rateLimit, Sleeper sleeper) {
		this.rateLimit = rateLimit;
		this.sleeper = sleeper;
	}
	
	public void intercept(HttpRequest request) throws IOException {
		rateLimit.decrementRateCount();
		int rateCount = rateLimit.getRateCount();
		long resetTime = rateLimit.getResetTime();
		System.out.println("This is the rateCount " + rateCount);
		System.out.println("This is the resetTime " + resetTime);
		if (rateCount < 0) {
			System.out.println("RateLimit Exceeded, computing next call");
			long timeNow = Calendar.getInstance().getTimeInMillis();
			if(timeNow < resetTime) {
				long delay = resetTime - timeNow;
				System.out.println("delay call (from interceptor) " + delay);
				try {
					sleeper.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
