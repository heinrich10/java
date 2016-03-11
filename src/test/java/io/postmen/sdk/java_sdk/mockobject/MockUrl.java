package io.postmen.sdk.java_sdk.mockobject;

import com.postmen.sdk.java_sdk.util.PostmenUrl;

public class MockUrl {
	private static PostmenUrl url = new PostmenUrl("http://www.google.com");
	
	public static PostmenUrl getUrl() {
		return url;
	}
}
