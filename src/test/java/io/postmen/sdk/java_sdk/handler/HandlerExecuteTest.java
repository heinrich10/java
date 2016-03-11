package io.postmen.sdk.java_sdk.handler;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.config.ConfigBuilder;
import com.postmen.sdk.java_sdk.exception.PostmenException;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.handler.PostmenSleeper;
import com.postmen.sdk.java_sdk.handler.PostmenUnsuccesfulResponseHandler;
import com.postmen.sdk.java_sdk.model.LabelRequest;
import com.postmen.sdk.java_sdk.model.LabelResponse;
import com.postmen.sdk.java_sdk.model.Response;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

import junit.framework.TestCase;

public class HandlerExecuteTest extends TestCase{
	
	private Handler handler;
	private Config config;
	private HttpHeaders headers;
	
	public HandlerExecuteTest() {
		// TODO Auto-generated constructor stub
		super("Handler Test");
	}
	
	@Before
	public void setUp() {
		config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").build();
    	handler = new Handler(config);
    	headers = new HttpHeaders();
		headers.setContentType("application/json");
		headers.set("postmen-api-key", "some-api-key");
		headers.set("x-postmen-agent", "java-sdk-1.0.0");
		headers.set("connection", "keep-alive");
	}
	
	@Test
	public void testCall() throws IOException, PostmenException {
		HttpTransport transport = new MockHttpTransport() {
			@Override
			public LowLevelHttpRequest buildRequest(String method, String url) {
				return new MockLowLevelHttpRequest() {
					public LowLevelHttpResponse execute() {
						MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
						response.addHeader("x-ratelimit-remaining", "9");
						response.addHeader("x-ratelimit-reset", "1457501223971");
						response.setStatusCode(200);
						response.setContentType(Json.MEDIA_TYPE);
						response.setContent("{\"meta\": {\"code\": 200,\"message\": \"OK\",\"details\": []}, \"data\": {}}");
						//response.setContent("{\"error\":\"not found\"}");
						return response;
					}
				};
			}
		};
		HttpRequestFactory requestFactory = transport.createRequestFactory(new HttpRequestInitializer() {
			
			public void initialize(HttpRequest request) throws IOException {
				// TODO Auto-generated method stub
				request.setParser(new JsonObjectParser(new JacksonFactory()));
				request.setHeaders(headers);
				request.setNumberOfRetries(5);
			}
		});
		
		Response response = handler.execute(requestFactory, "GET", new PostmenUrl(config), new LabelRequest(), LabelResponse.class);
		
		assertTrue(response instanceof Response);
		assertTrue(response instanceof LabelResponse);
	}
	
	@Test(expected=PostmenException.class)
	public void testNotRetryable() {
		HttpTransport transport = new MockHttpTransport() {
			@Override
			public LowLevelHttpRequest buildRequest(String method, String url) {
				return new MockLowLevelHttpRequest() {
					public LowLevelHttpResponse execute() {
						MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
						response.addHeader("x-ratelimit-remaining", "9");
						response.addHeader("x-ratelimit-reset", "1457501223971");
						response.setStatusCode(200);
						response.setContentType(Json.MEDIA_TYPE);
						response.setContent("{\"meta\": {\"code\": 9999,\"message\": \"OK\",\"details\": [], \"retryable\": false}, \"data\": {}}");
						//response.setContent("{\"error\":\"not found\"}");
						return response;
					}
				};
			}
		};
		HttpRequestFactory requestFactory = transport.createRequestFactory(new HttpRequestInitializer() {
			
			public void initialize(HttpRequest request) throws IOException {
				// TODO Auto-generated method stub
				request.setParser(new JsonObjectParser(new JacksonFactory()));
				request.setHeaders(headers);
				request.setNumberOfRetries(5);
			}
		});
		try {
			handler.execute(requestFactory, "GET", new PostmenUrl(config), null, LabelResponse.class);
		} catch (IOException e) {

		}
	}
	
	@Test(expected=PostmenException.class)
	public void testRetryableThenFail() {
		HttpTransport transport = new MockHttpTransport() {
			@Override
			public LowLevelHttpRequest buildRequest(String method, String url) {
				return new MockLowLevelHttpRequest() {
					public LowLevelHttpResponse execute() {
						MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
						response.addHeader("x-ratelimit-remaining", "9");
						response.addHeader("x-ratelimit-reset", "1457501223971");
						response.setStatusCode(200);
						response.setContentType(Json.MEDIA_TYPE);
						response.setContent("{\"meta\": {\"code\": 9999,\"message\": \"OK\",\"details\": [], \"retryable\": true}, \"data\": {}}");
						//response.setContent("{\"error\":\"not found\"}");
						return response;
					}
				};
			}
		};
		HttpRequestFactory requestFactory = transport.createRequestFactory(new HttpRequestInitializer() {
			
			public void initialize(HttpRequest request) throws IOException {
				// TODO Auto-generated method stub
				request.setParser(new JsonObjectParser(new JacksonFactory()));
				request.setHeaders(headers);
				request.setNumberOfRetries(5);
			}
		});
		
		PostmenUnsuccesfulResponseHandler rHandler = new PostmenUnsuccesfulResponseHandler(new PostmenSleeper()) {
			private int i = 5;
			@Override
			public <T extends Response> boolean handleResponse(HttpRequest request, T response, boolean shouldRetry) {
				i--;
				if(i < 0) {
					return false;
				} else {
					return true;
				}
			}
		};
		try {
			handler.setResponseHandler(rHandler);
			handler.execute(requestFactory, "GET", new PostmenUrl(config), null, LabelResponse.class);
		} catch (IOException e) {
		
		}
	}
	
}
