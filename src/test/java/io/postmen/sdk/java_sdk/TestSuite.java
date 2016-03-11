package io.postmen.sdk.java_sdk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import io.postmen.sdk.java_sdk.handler.HandlerExecuteTest;
import io.postmen.sdk.java_sdk.handler.HandlerTest;
import io.postmen.sdk.java_sdk.handler.RateLimitExecuteInterceptorTest;
import io.postmen.sdk.java_sdk.handler.ResponseHandlerTest;

/**
 * Unit test for simple App.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlerExecuteTest.class,
	HandlerTest.class,
	RateLimitExecuteInterceptorTest.class,
	ResponseHandlerTest.class
})

public class TestSuite {

}
