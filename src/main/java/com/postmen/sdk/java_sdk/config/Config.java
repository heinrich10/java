package com.postmen.sdk.java_sdk.config;

public class Config implements Cloneable {
	
	private String apiKey;
	private String url;
	private String version;
	private ProxyConfig proxy;
	private boolean retry;
	private boolean rate;
	
	public Config(){
	}
	
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	public ProxyConfig getProxy() {
		return proxy;
	}
	
	public void setProxy(ProxyConfig proxy) {
		this.proxy = proxy;
	}
	
	public void setRetry(Boolean retry) {
		this.retry = retry;
	}

	public boolean isRetry() {
		return retry;
	}
	
	public void setRate(Boolean rate) {
		this.rate = rate;
	}

	public boolean isRate() {
		return rate;
	}
	
	public Config clone() {
		Config clone =  new Config();
		clone.apiKey = this.apiKey;
		clone.proxy = this.proxy;
		clone.url = this.url;
		clone.version = this.version;
		clone.rate = this.rate;
		clone.retry = this.retry;
		
		return clone;
	}

}
