package com.postmen.javasdk.examples;

import java.io.IOException;

import com.postmen.javasdk.config.Config;
import com.postmen.javasdk.config.ConfigBuilder;
import com.postmen.javasdk.exception.PostmenException;
import com.postmen.javasdk.model.CancelLabelRequest;
import com.postmen.javasdk.model.CancelLabelResponse;
import com.postmen.javasdk.model.CancelLabelsResponse;
import com.postmen.javasdk.model.LabelInfo;
import com.postmen.javasdk.model.LabelResponse;
import com.postmen.javasdk.service.CancelLabelService;
import com.postmen.javasdk.service.LabelService;

public class CancelLabelExample {
	
	private static final String apiKey = "8552df2f-66dc-4585-a02e-9dc7cba7a45f";
	
	public static void cancel() {
		
		try {
			Config config = new ConfigBuilder().setApiKey(apiKey).setUrl("https://sandbox-api.postmen.io/").build();
			CancelLabelService cancelService = new CancelLabelService(config);
			LabelService labelService = new LabelService(config);
			System.out.println("Creating Label");
			LabelResponse response = labelService.create(ExampleHelper.createLabelRequest());
			ExampleHelper.printObject(response);
			
			LabelInfo label = new LabelInfo(response.getData().getId());
			CancelLabelRequest req = new CancelLabelRequest(label);
			req.setAsync(false);
			CancelLabelResponse res = cancelService.cancel(req);
			ExampleHelper.printObject(res);
			
		} catch (PostmenException e) {
			ExampleHelper.printObject(e.getResponse().getMeta().getDetail());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void get() {
		Config config = new ConfigBuilder().setApiKey(apiKey).setUrl("https://sandbox-api.postmen.io/").build();
		CancelLabelService cancelService = new CancelLabelService(config);	
		try {
			CancelLabelsResponse response = cancelService.get();
			ExampleHelper.printObject(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getOne() {
		
		Config config = new ConfigBuilder().setApiKey(apiKey).setUrl("https://sandbox-api.postmen.io/").build();
		CancelLabelService cancelService = new CancelLabelService(config);	
		try {
			CancelLabelResponse response = cancelService.get("fee3c300-a321-429a-bd0b-595a80fd7dc2");
			ExampleHelper.printObject(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
