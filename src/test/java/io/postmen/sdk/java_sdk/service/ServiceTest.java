package io.postmen.sdk.java_sdk.service;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.config.ConfigBuilder;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.MapResponse;
import com.postmen.sdk.java_sdk.service.Service;

import io.postmen.sdk.java_sdk.mockobject.MockHandler;
import junit.framework.TestCase;

public class ServiceTest extends TestCase{
	
	private Config config;
	private ServiceTestClass serviceTestClass;
	private String name = "test";
	
	@Before
	public void setUp() {
		config = new ConfigBuilder().build();
		serviceTestClass = new ServiceTestClass(config, name);
	}
	
	@Test
	public void testGetServiceName() {
		assertEquals(name, serviceTestClass.getServiceName());
	}
	
	@Test
	public void testGetHandler() {
		assertTrue(serviceTestClass.getHandler() instanceof Handler);
	}
	
	public class ServiceTestClass extends Service {
		public ServiceTestClass(Config config, String serviceName) {
			super(new MockHandler(config), config, serviceName);
		}
		
		public String getServiceName() {
			return super.getServiceName();
		}
		
		public Handler getHandler() {
			return super.getHandler();
		}
	}	
}
