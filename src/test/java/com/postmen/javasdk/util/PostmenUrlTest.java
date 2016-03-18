package com.postmen.javasdk.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.config.ConfigBuilder;
import com.postmen.javasdk.exception.ConfigException;
import com.postmen.javasdk.util.PostmenUrl;

import junit.framework.TestCase;

public class PostmenUrlTest extends TestCase {
	/*
	@Test
	public void testUrl() throws ConfigException {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").setApiKey("asd").build();
		PostmenUrl url = new PostmenUrl(config);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testUrlWithoutEndSlash() throws ConfigException {
		Config config = new ConfigBuilder().setUrl("http://www.test.com").setApiKey("asd").build();
		PostmenUrl url = new PostmenUrl(config);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testAppendPath() throws ConfigException {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").setApiKey("asd").build();
		PostmenUrl url = new PostmenUrl(config, "new");
		assertEquals("http://www.test.com/v3/new", url.toString());
	}
	
	@Test
	public void testAddPathParts() throws ConfigException {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").setApiKey("asd").build();
		PostmenUrl url = new PostmenUrl(config);
		url.appendPath(null);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testAddQueryString() throws ConfigException {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").setApiKey("asd").build();
		PostmenUrl url = new PostmenUrl(config, "new");
		Map<String, String> qs = new HashMap<String, String>();
		qs.put("one", "two");
		url.addQueries(qs);
		assertEquals("http://www.test.com/v3/new?one=two", url.toString());
	}
	*/
}
