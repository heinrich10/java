package com.postmen.sdk.java_sdk.handler;

import com.google.api.client.util.Sleeper;

public class PostmenSleeper implements Sleeper {

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

}
