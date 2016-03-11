package com.postmen.javasdk.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.config.ConfigBuilder;
import com.postmen.javasdk.util.PostmenUrl;

import junit.framework.TestCase;

public class PostmenUrlTest extends TestCase {
	
	@Test
	public void testUrl() {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").build();
		PostmenUrl url = new PostmenUrl(config);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testUrlWithoutEndSlash() {
		Config config = new ConfigBuilder().setUrl("http://www.test.com").build();
		PostmenUrl url = new PostmenUrl(config);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testAppendPath() {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").build();
		PostmenUrl url = new PostmenUrl(config, "new");
		assertEquals("http://www.test.com/v3/new", url.toString());
	}
	
	@Test
	public void testAddPathParts() {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").build();
		PostmenUrl url = new PostmenUrl(config);
		url.appendPath(null);
		assertEquals("http://www.test.com/v3", url.toString());
	}
	
	@Test
	public void testAddQueryString() {
		Config config = new ConfigBuilder().setUrl("http://www.test.com/").build();
		PostmenUrl url = new PostmenUrl(config, "new");
		Map<String, String> qs = new HashMap<String, String>();
		qs.put("one", "two");
		url.addQueries(qs);
		assertEquals("http://www.test.com/v3/new?one=two", url.toString());
	}
}
