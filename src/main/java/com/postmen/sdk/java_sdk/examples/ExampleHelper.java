package com.postmen.sdk.java_sdk.examples;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.postmen.sdk.java_sdk.model.Address;
import com.postmen.sdk.java_sdk.model.Customs;
import com.postmen.sdk.java_sdk.model.Dimension;
import com.postmen.sdk.java_sdk.model.Item;
import com.postmen.sdk.java_sdk.model.LabelRequest;
import com.postmen.sdk.java_sdk.model.Money;
import com.postmen.sdk.java_sdk.model.Parcel;
import com.postmen.sdk.java_sdk.model.Shipment;
import com.postmen.sdk.java_sdk.model.ShipperAccount;
import com.postmen.sdk.java_sdk.model.Weight;

public class ExampleHelper {
	
	private static Gson gson = new Gson();
	
	public static void printObject(Object object){
		String json = gson.toJson(object);
		System.out.println(json);
	}
	
	public static LabelRequest createLabelRequest() {
		LabelRequest req = new LabelRequest();
		
		req.setAsync(false);
		req.setServiceType("spsr_intl");
		
		ShipperAccount shipperAccount = new ShipperAccount("1fa0af68-4651-43d2-b3b3-45c1da063b0a");
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
		shipTo.setCountry("RUS");
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
		return req;
	}
}
