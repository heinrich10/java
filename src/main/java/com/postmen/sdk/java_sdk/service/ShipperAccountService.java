package com.postmen.sdk.java_sdk.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.handler.Handler;
import com.postmen.sdk.java_sdk.model.Response;
import com.postmen.sdk.java_sdk.model.ShipperAccount;
import com.postmen.sdk.java_sdk.model.ShipperAccountResponse;
import com.postmen.sdk.java_sdk.model.ShipperAccounts;
import com.postmen.sdk.java_sdk.model.ShipperAccountsResponse;
import com.postmen.sdk.java_sdk.util.PostmenUrl;

public class ShipperAccountService extends Service{
	
	public ShipperAccountService(Config config) {
		super(config, "shipper-accounts");
	}
	
	public ShipperAccounts get() throws IOException {
		PostmenUrl url = getUrl();
		ShipperAccountsResponse shipperAccountsResponse = get(getHandler(), url, ShipperAccountsResponse.class);
		return shipperAccountsResponse.getData();
	}
	
	public ShipperAccounts get(Config config) throws IOException {
		Handler handler = new Handler(config);
		PostmenUrl url = getUrl(config);
		ShipperAccountsResponse shipperAccountsResponse = get(handler, url, ShipperAccountsResponse.class);
		return shipperAccountsResponse.getData();
	}
	
	public ShipperAccount get(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		ShipperAccountResponse shipperAccountResponse = get(getHandler(), url, ShipperAccountResponse.class);
		return shipperAccountResponse.getData();
	}
	
	public ShipperAccount get(String id, Config config) throws IOException {
		Handler handler = new Handler(config);
		PostmenUrl url = getUrl(config).appendPath(id);
		ShipperAccountResponse shipperAccountResponse = get(handler, url, ShipperAccountResponse.class);
		return shipperAccountResponse.getData();
	}
	
	public ShipperAccount create(ShipperAccount shipperAccount) throws IOException {
		PostmenUrl url = getUrl();
		ShipperAccountResponse shipperAccountResponse = post(getHandler(), url, shipperAccount, ShipperAccountResponse.class);
		return shipperAccountResponse.getData();
	}
	
	public ShipperAccount create(ShipperAccount shipperAccount, Config config) throws IOException {
		PostmenUrl url = getUrl(config);
		ShipperAccountResponse shipperAccountResponse = post(getHandler(), url, shipperAccount, ShipperAccountResponse.class);
		return shipperAccountResponse.getData();
	}
	
	public Boolean delete(String id) throws IOException {
		PostmenUrl url = getUrl().appendPath(id);
		
		Response response = delete(getHandler(), url, Response.class);
		
		if(response.getMeta().getCode() == 200) {
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean delete(String id, Config config) throws IOException {
		Handler handler = new Handler(config);
		PostmenUrl url = getUrl(config).appendPath(id);
		Response response = delete(handler, url, Response.class);
		
		if(response.getMeta().getCode() == 200) {
			return true;
		} else {
			return false;
		}
	}

	public Future<ShipperAccountsResponse> getAsync() throws IOException, InterruptedException, ExecutionException {
		PostmenUrl url = getUrl();
		return getAsync(getHandler(), url, ShipperAccountsResponse.class);
	}
	
	public Future<ShipperAccountResponse> getAsync(String id) throws InterruptedException {
		PostmenUrl url = getUrl().appendPath(id);
		return getAsync(getHandler(), url, ShipperAccountResponse.class);
	}
}
