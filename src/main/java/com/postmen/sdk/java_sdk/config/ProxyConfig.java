package com.postmen.sdk.java_sdk.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.Proxy.Type;

public class ProxyConfig {
	private Type type;
	private String url;
	private Integer port;
	private String proxyUsername;
	private String proxyPassword;
	
	public ProxyConfig(Type type, String url, Integer port) {
		this.type = type;
		this.url = url;
		this.port = port;
	}

	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}
	
	public Proxy getProxy() {
		return new Proxy(type, new InetSocketAddress(url, port));
	}
}
