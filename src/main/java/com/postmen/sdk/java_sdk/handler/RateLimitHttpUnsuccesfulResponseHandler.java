package com.postmen.sdk.java_sdk.handler;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Sleeper;

public class RateLimitHttpUnsuccesfulResponseHandler implements HttpUnsuccessfulResponseHandler{
	
	private static final int numRetries = 5;
	private Logger logger = LoggerFactory.getLogger(RateLimitHttpUnsuccesfulResponseHandler.class);
	
	public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry)
			throws IOException {
		boolean retry = supportsRetry;
		int statusCode = response.getStatusCode();
		logger.debug("status code is {}", statusCode);
		if (retry && request.getNumberOfRetries() <= 0) {
			retry = false;
		}
		
		if (retry && !supportsRetry) {
			retry = false;
		}
		
		BackOff backOff = null;
		long delay = 0;
		if (retry) {	
			if(statusCode == 429) {
				String time = response.getHeaders().getFirstHeaderStringValue("X-RateLimit-Reset");
				long longNextDate = Long.parseLong(time);
				long longNow = Calendar.getInstance().getTimeInMillis();
				delay =  longNextDate - longNow;
				System.out.println("Rate Limit Exceeded " + delay);
			} else if(statusCode >= 500){
				delay = getDelay(request);
				backOff = new PostmenBackOff(delay);
				System.out.println("500 error " + delay);
			} 
			try {
				backOff = new PostmenBackOff(delay);
				return BackOffUtils.next(Sleeper.DEFAULT, backOff);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return retry;
	}
	
	private long getDelay(HttpRequest request) {
		int pow = numRetries - request.getNumberOfRetries();
		long delay = (long) Math.pow(2, pow);
		System.out.println("retrying in " + delay + " for the " + pow + " times");
		return delay;
	}
}

