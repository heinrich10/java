package io.postmen.sdk.java_sdk.service;

import org.junit.Before;
import org.junit.Test;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.config.ConfigBuilder;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.service.Service;

import junit.framework.TestCase;

public class ServiceTest extends TestCase{
	
	private Config config;
	
	@Before
	public void setUp() {
		config = new ConfigBuilder().build();
	}
	
	@Test
	public void testGetServiceName() {
		
	}
	
	public class ServiceTestClass extends Service {
		public ServiceTestClass(Config config, String serviceName) {
			super(new Handler(config), config, serviceName);
		}
		
		public String getServiceName() {
			return getServiceName();
		}
	}
	
	
	/*
	public class ChildService extends Service{
		public Config getConfig() {
			return config;
		}
		public HttpHeaders getHeaders(){
			return headers;
		}
	}
	
	private ChildService service;
	private String apiKey = "test";
	
	@Before
	public void setUp() {
		ConfigBuilder cb = new ConfigBuilder();
		cb.setApiKey(apiKey);
		ConfigFactory.setConfig(cb);
		service = new ChildService();
	}
	
	@Test
	public void testConfig() {
		assertEquals(ConfigFactory.getConfig(), service.getConfig());
		assertEquals(service.getHeaders().getContentType(), "application/json");
		assertEquals(service.getHeaders().get("postmen-api-key"), ConfigFactory.getConfig().getApiKey());
	}
	*/
	
}
