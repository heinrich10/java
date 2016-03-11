package com.postmen.javasdk.handler;

import com.google.api.client.util.Sleeper;

public class PostmenSleeper implements Sleeper {

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

}
