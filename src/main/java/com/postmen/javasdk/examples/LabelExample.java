package com.postmen.javasdk.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.config.ConfigBuilder;
import com.postmen.javasdk.model.Address;
import com.postmen.javasdk.model.Customs;
import com.postmen.javasdk.model.Dimension;
import com.postmen.javasdk.model.Item;
import com.postmen.javasdk.model.LabelRequest;
import com.postmen.javasdk.model.LabelResponse;
import com.postmen.javasdk.model.LabelsResponse;
import com.postmen.javasdk.model.Money;
import com.postmen.javasdk.model.Parcel;
import com.postmen.javasdk.model.Shipment;
import com.postmen.javasdk.model.ShipperAccount;
import com.postmen.javasdk.model.Weight;
import com.postmen.javasdk.service.LabelService;

public class LabelExample {
	
	private static final String apiKey = "5c0a9482-930f-49d8-a319-ea3d24081ad2";
	
	public static void create() {
		try {
			Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
	    	
			LabelService service = new LabelService(config);
			LabelRequest req = new LabelRequest();
			
			req.setAsync(false);
			req.setServiceType("dhl-global-mail-asia_plt");
			
			ShipperAccount shipperAccount = new ShipperAccount("86aa7860-f765-4462-8022-625705605573");
			req.setShipperAccount(shipperAccount);
			
			Shipment shipment = new Shipment();
			Parcel parcel = new Parcel();
			parcel.setDescription("Parcel");
			parcel.setBoxType("custom");
			
			parcel.setWeight(new Weight(1.5, "kg"));
			parcel.setDimension(new Dimension(20, 30, 30, "cm"));
			
			Item item = new Item();
			item.setDescription("Food Bar");
			item.setOriginCountry("USA");
			item.setQuantity(2);
			
			item.setPrice(new Money(50, "USD"));
			
			item.setWeight(new Weight(0.6, "kg"));
			item.setSku("Epic_Food_Bar");
			item.setHsCode("7877966");
			
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			parcel.setItems(items);
			
			Address shipFrom = new Address();
			shipFrom.setContactName("Joe Smith");
			shipFrom.setCompanyName("Aftership");
			shipFrom.setStreet1("bal");
			shipFrom.setCity("NT");
			shipFrom.setState("HK");
			shipFrom.setPostalCode("N/A");
			shipFrom.setCountry("HKG");
			shipFrom.setPhone("123456789");
			shipFrom.setEmail("mail@mail.com");
			shipFrom.setType("business");
			
			Address shipTo = new Address();
			shipTo.setContactName("Jon Poole");
			shipTo.setStreet1("test");
			shipTo.setCity("Concord");
			shipTo.setState("New Hampshire");
			shipTo.setPostalCode("03301");
			shipTo.setCountry("USA");
			shipTo.setPhone("12345");
			shipTo.setEmail("test@test.com");
			shipTo.setType("residential");
			
			List<Parcel> parcels = new ArrayList<Parcel>();
			parcels.add(parcel);
			shipment.setParcels(parcels);
			shipment.setShipFrom(shipFrom);
			shipment.setShipTo(shipTo);
			req.setShipment(shipment);
			
			Customs customs = new Customs();
			customs.setPurpose("gift");
			customs.setTermsOfTrade("ddu");
			req.setCustoms(customs);
	    	
			LabelResponse label = service.create(req);
	    	
			ExampleHelper.printObject(label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getOne() {
		try {
			Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
	    	
			LabelService service = new LabelService(config);
			LabelResponse label = service.get("1ca43067-5782-406d-b042-69a3f644f2f3");
			ExampleHelper.printObject(label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void get() {
		try {
			Config config = new ConfigBuilder().setRetry(true).setRate(true).setUrl("http://localhost:8001/").setApiKey(apiKey).build();
	    	
			LabelService service = new LabelService(config);
			LabelsResponse label = service.get();
			ExampleHelper.printObject(label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
