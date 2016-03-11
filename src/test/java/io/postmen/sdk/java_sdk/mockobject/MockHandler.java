package io.postmen.sdk.java_sdk.mockobject;

import java.util.Map;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.MapResponse;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

public class MockHandler extends Handler{

	public MockHandler(Config config) {
		super(config);
	}
	
	@Override
	public MapResponse callAndParseAsMap(String method, PostmenUrl url, Object body) {
		return null;
	}
	
	@Override
	public String callAndParseAsString(String method, PostmenUrl url, Object body) {
		return null;
	}

}
