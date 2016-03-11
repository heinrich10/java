package com.postmen.sdk.java_sdk.handler;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.util.Sleeper;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.postmen.sdk.java_sdk.model.Response;

public class PostmenUnsuccesfulResponseHandler {
	
	private int retriesLeft;
	private Sleeper sleeper;
	
	public PostmenUnsuccesfulResponseHandler(Sleeper sleeper) {
		retriesLeft = 5; 
		this.sleeper = sleeper;
	}
	
	public <T extends Response> boolean handleResponse(HttpRequest request, T response, boolean shouldRetry) {
		long delay = 0;
		Boolean retry = true;
		try {
			if (retriesLeft > 0 && shouldRetry) {
				Boolean retryable = response.getMeta().isRetryable();
				if (retryable == null) {
					retryable = false;
				}
				if(retryable) {
					delay = getDelay(request) * 1000;
					sleeper.sleep(delay);
					retriesLeft--;
				} else {
					retry = false;
					
				}
			} else {
				retry = false;
			}
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retry;
	}
	
	private long getDelay(HttpRequest request) {
		int pow = request.getNumberOfRetries() - retriesLeft;
		long delay = (long) Math.pow(2, pow);
		// System.out.println("retrying in " + delay + " for the " + (int)(pow + 1) + " times");
		return delay;
	}
	
}
