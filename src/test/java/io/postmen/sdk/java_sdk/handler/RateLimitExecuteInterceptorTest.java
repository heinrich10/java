package io.postmen.sdk.java_sdk.handler;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.util.Sleeper;
import com.postmen.sdk.java_sdk.handler.RateLimit;
import com.postmen.sdk.java_sdk.handler.RateLimitExecuteInterceptor;

import junit.framework.TestCase;

public class RateLimitExecuteInterceptorTest extends TestCase {
	
	private RateLimitExecuteInterceptor interceptor;
	private HttpTransport transport;
	private SleeperTest sleeper;
	private RateLimit rateLimit;
	
	public RateLimitExecuteInterceptorTest() {
		// TODO Auto-generated constructor stub
		super("Rate Limite Interceptor");
	}
	
	@Before
	public void setUp() {
		transport = new MockHttpTransport();
		sleeper = new SleeperTest();
		rateLimit = new RateLimit();
		interceptor = new RateLimitExecuteInterceptor(rateLimit, sleeper);
	}
	
	@Test
	public void testInterceptFirstTime() {
		try {
			HttpRequest request = transport.createRequestFactory().buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
			interceptor.intercept(request);
			assertNull(sleeper.getDelay());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}	
	}
	
	@Test
	public void testInterceptWhenRateLimitIsZero() {
		try {
			HttpRequest request = transport.createRequestFactory().buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
			long time = Calendar.getInstance().getTimeInMillis() + 5000;
			rateLimit.setResetTime(time);
			rateLimit.setRateCount(-1);
			interceptor.intercept(request);
			Double delay = sleeper.getDelay().doubleValue();
			delay = Math.ceil(delay/10) * 10;
			assertEquals(5000, delay.intValue());
			System.out.println(sleeper.getDelay());
		} catch (IOException e) {
			
		}
	}
	
	public class SleeperTest implements Sleeper {
		private Long delay;
		public void sleep(long millis) throws InterruptedException {
			delay = millis;
		}
		public Long getDelay() {
			return delay;
		}
	}
}
