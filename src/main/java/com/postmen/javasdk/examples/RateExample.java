package com.postmen.javasdk.examples;

import java.io.IOException;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.config.ConfigBuilder;
import com.postmen.javasdk.model.Address;
import com.postmen.javasdk.model.Dimension;
import com.postmen.javasdk.model.Item;
import com.postmen.javasdk.model.Money;
import com.postmen.javasdk.model.Parcel;
import com.postmen.javasdk.model.RateRequest;
import com.postmen.javasdk.model.RateResponse;
import com.postmen.javasdk.model.RatesResponse;
import com.postmen.javasdk.model.Shipment;
import com.postmen.javasdk.model.ShipperAccount;
import com.postmen.javasdk.model.Weight;
import com.postmen.javasdk.service.RateService;

public class RateExample {
	private static final String apiKey = "5c0a9482-930f-49d8-a319-ea3d24081ad2";
	
	public static void calculate() {
		Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
		RateService service = new RateService(config);
		try {
			
			RateRequest req = new RateRequest();
			req.setAsync(false);
			req.addShipperAccount(new ShipperAccount("c5573168-f4f6-4042-bf6c-54ef46c9d7c6"));
			
			Item item = new Item();
			item.setDescription("PS4");
			item.setOriginCountry("JPN");
			item.setQuantity(1);
			item.setPrice(new Money(50, "HKD"));
			item.setWeight(new Weight(0.6, "kg"));
			item.setSku("PS4-2015");

			
			Parcel parcel = new Parcel();
			parcel.setBoxType("custom");
			parcel.setWeight(new Weight(0.5, "kg"));
			parcel.setDimension(new Dimension(20, 10, 10, "cm"));
			parcel.addItems(item);
			
			Address sender = new Address();
			sender.setContactName("Yin Ting Mong");
			sender.setStreet1("Test Address");
			sender.setCity("hung Hom");
			sender.setState("KLN");
			sender.setCountry("HKG");
			sender.setPhone("1234567");
			sender.setEmail("maiul@mail.com");
			sender.setType("residential");

			Address receiver = new Address();
			receiver.setContactName("Yin Ting Mong");
			receiver.setStreet1("Test Address");
			receiver.setCity("hung Hom");
			receiver.setState("KLN");
			receiver.setCountry("USA");
			receiver.setPhone("1234567");
			receiver.setEmail("maiul@mail.com");
			receiver.setType("residential");

			

			Shipment shipment = new Shipment();
			shipment.setShipFrom(sender);
			shipment.setShipTo(receiver);
			shipment.addParcels(parcel);
			
			req.setShipment(shipment);
			
			RateResponse data = service.calculate(req);
			ExampleHelper.printObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void get(){
		Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
		RateService service = new RateService(config);
		try {
			RatesResponse rates = service.get();
			ExampleHelper.printObject(rates);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void getOne() {
		Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
    	
		RateService service = new RateService(config);
		try {
			RateResponse rate = service.get("4df31ceb-9f4a-48e9-88f1-04d334923e71");
			ExampleHelper.printObject(rate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
