package com.postmen.javasdk.handler;

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
	
	private Logger logger = LoggerFactory.getLogger(RateLimitHttpUnsuccesfulResponseHandler.class);
	private Sleeper sleeper;
	private RateLimit rateLimit;
	private ExpBackOff expBackOff;
	
	public RateLimitHttpUnsuccesfulResponseHandler(Sleeper sleeper, RateLimit rateLimit, ExpBackOff expBackOff) {
		this.sleeper = sleeper;
		this.rateLimit = rateLimit;
		this.expBackOff = expBackOff;
		// this.numberOfRetries = numberOfRetries;
	}
	
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
				rateLimit.setRateLimit(response.getHeaders());
				long time = Calendar.getInstance().getTimeInMillis();
				backOff = new RateLimitBackOff(time, rateLimit);
				System.out.println("Rate Limit Exceeded " + delay);
			} else if(statusCode >= 500){
				backOff = expBackOff;
				// numberOfRetries--;
				System.out.println("500 error " + delay);
			} 
			try {
				return BackOffUtils.next(sleeper, backOff);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return retry;
	}
}

