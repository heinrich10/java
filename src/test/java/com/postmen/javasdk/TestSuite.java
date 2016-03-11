package com.postmen.javasdk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.postmen.javasdk.handler.HandlerExecuteTest;
import com.postmen.javasdk.handler.HandlerTest;
import com.postmen.javasdk.handler.PostmenUnsuccessfulResponseHandlerTest;
import com.postmen.javasdk.handler.RateLimitExecuteInterceptorTest;

/**
 * Unit test for simple App.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlerExecuteTest.class,
	HandlerTest.class,
	RateLimitExecuteInterceptorTest.class,
	PostmenUnsuccessfulResponseHandlerTest.class
})

public class TestSuite {

}
