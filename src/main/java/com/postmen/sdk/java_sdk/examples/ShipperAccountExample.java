package com.postmen.sdk.java_sdk.examples;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.config.ConfigBuilder;
import com.postmen.sdk.java_sdk.model.Address;
import com.postmen.sdk.java_sdk.model.MapResponse;
import com.postmen.sdk.java_sdk.model.ShipperAccount;
import com.postmen.sdk.java_sdk.model.ShipperAccountResponse;
import com.postmen.sdk.java_sdk.model.ShipperAccounts;
import com.postmen.sdk.java_sdk.service.ShipperAccountService;

public class ShipperAccountExample {
	
	private static final String apiKey = "5c0a9482-930f-49d8-a319-ea3d24081ad2";
	
	public static void get() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = null;
    	try {
    		service = new ShipperAccountService(config);
			ShipperAccounts shipperAccounts = service.get();
			ExampleHelper.printObject(shipperAccounts);
			Config nConfig = config.clone();
			nConfig.setRetry(false);
			service.get(nConfig);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getOne() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = null;
    	try {
    		service = new ShipperAccountService(config);
    		ShipperAccount shipperAccount = service.get("df009f0c-f033-4a98-82e8-7221e77997fe");
			ExampleHelper.printObject(shipperAccount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createAndDelete() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = null;
    	try {
    		service = new ShipperAccountService(config);
			ShipperAccounts shipperAccounts = service.get();
			ExampleHelper.printObject(shipperAccounts);
			
			// creating shipper account object
			Address address = new Address();
			address.setContactName("Sir Foo");
			address.setPhone("123456t");
			address.setFax("1231323123");
			address.setEmail("test@test.com");
			address.setCompanyName("Foo Store");
			address.setStreet1("Somewhere Out There");
			address.setCity("SomeCity");
			address.setPostalCode("L4W5M8");
			address.setState("State");
			address.setCountry("CAN");
			address.setType("business");
			ShipperAccount create = new ShipperAccount();
			create.setCredentials("account_number", "12345");
			create.setCredentials("key", "ac1df8ddcd024e4e976f87e2da5b6ce3");
			create.setCredentials("key_password", "}*(pR73Z");
			create.setTimezone("America/Vancouver");
			create.setAddress(address);
			create.setSlug("purolator");
			create.setDescription("testing");	
			
			// sending
			ShipperAccount shipperAccount = service.create(create);
			ExampleHelper.printObject(shipperAccount);
			
			System.out.println("is deleted? " + service.delete(shipperAccount.getId()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAsync() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = null;
		service = new ShipperAccountService(config);
		Future<ShipperAccountResponse> shipperAccount;
		try {
			shipperAccount = service.getAsync("df009f0c-f033-4a98-82e8-7221e77997fe");
			ExampleHelper.printObject(shipperAccount.get().getData());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	
	public static void getMap() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = new ShipperAccountService(config);
    	try {
			MapResponse response =  service.callAsMap("GET", "df009f0c-f033-4a98-82e8-7221e77997fe", null, null);
			Map<Object, Object> data = response.getData();
			String date = (String) data.get("created_at");
			ExampleHelper.printObject(response.getData());
			System.out.println(date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getRaw() {
		ConfigBuilder cb = new ConfigBuilder();
    	Config config = cb.setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
    	ShipperAccountService service = new ShipperAccountService(config);
    	
    	try {
    		String response = service.callAsRaw("GET", "df009f0c-f033-4a98-82e8-7221e77997fe", null, null);
    		System.out.println(response);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
}
