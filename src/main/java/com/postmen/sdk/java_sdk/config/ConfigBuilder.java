package com.postmen.sdk.java_sdk.config;

public class ConfigBuilder {
	private String apiKey = null;
	private String url = "https://secure.postmen.io/";
	private String version = "v3";
	private String proxyUrl = null;
	private int proxyPort = 80;
	private boolean retry = true;
	private boolean rate = true;
	
	public ConfigBuilder() {
		
	}
	
	public ConfigBuilder(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public ConfigBuilder(String apiKey, boolean retry, boolean rate) {
		this.apiKey = apiKey;
		this.retry = retry;
		this.rate = rate;
	}
	
	public ConfigBuilder setApiKey(String apiKey) {
		this.apiKey = apiKey;
		return this;
	}
	
	public ConfigBuilder setUrl(String url){
		this.url = url;
		return this;
	}
	public ConfigBuilder setVersion(String version){
		this.version = version;
		return this;
	}
	public ConfigBuilder setProxyUrl(String proxyUrl){
		this.proxyUrl = proxyUrl;
		return this;
	}
	public ConfigBuilder setProxyPort(int proxyPort){
		this.proxyPort = proxyPort;
		return this;
	}
	public ConfigBuilder setRetry(boolean retry){
		this.retry = retry;
		return this;
	}
	public ConfigBuilder setRate(boolean rate){
		this.rate = rate;
		return this;
	}
	
	public Config build() {
		Config config = new Config();
		config.setApiKey(apiKey);
		config.setProxyPort(proxyPort);
		config.setProxyUrl(proxyUrl);
		config.setRate(rate);
		config.setRetry(retry);
		config.setUrl(url);
		config.setVersion(version);
		
		return config;
	}
}
