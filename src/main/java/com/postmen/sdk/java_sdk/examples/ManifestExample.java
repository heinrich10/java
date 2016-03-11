package com.postmen.sdk.java_sdk.examples;

import java.io.IOException;

import com.postmen.sdk.java_sdk.config.Config;
import com.postmen.sdk.java_sdk.config.ConfigBuilder;
import com.postmen.sdk.java_sdk.model.LabelResponse;
import com.postmen.sdk.java_sdk.model.ManifestRequest;
import com.postmen.sdk.java_sdk.model.ManifestResponse;
import com.postmen.sdk.java_sdk.service.LabelService;
import com.postmen.sdk.java_sdk.service.ManifestService;

public class ManifestExample {

	private static final String apiKey = "8552df2f-66dc-4585-a02e-9dc7cba7a45f";
	
	public static void manifest() {
		
		Config config = new ConfigBuilder().setApiKey(apiKey).setUrl("https://sandbox-api.postmen.io/").build();
		LabelService labelService = new LabelService(config);
		ManifestService manifestService = new ManifestService(config);
		
		try {
			LabelResponse labelResponse = labelService.create(ExampleHelper.createLabelRequest());
			ExampleHelper.printObject(labelResponse);
			ManifestRequest req = new ManifestRequest("1fa0af68-4651-43d2-b3b3-45c1da063b0a");
			req.setAsync(false);
			ManifestResponse manifestResponse = manifestService.manifest(req);
			ExampleHelper.printObject(manifestResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
