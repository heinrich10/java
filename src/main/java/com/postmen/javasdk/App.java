package com.postmen.javasdk;

import com.postmen.javasdk.examples.CancelLabelExample;
import com.postmen.javasdk.examples.LabelExample;
import com.postmen.javasdk.examples.ManifestExample;
import com.postmen.javasdk.examples.RateExample;
import com.postmen.javasdk.examples.ShipperAccountExample;

/**
 * Hello world!
 *
 */
public class App 
{
	// personal API key in test
	// private static final String apiKey = "8552df2f-66dc-4585-a02e-9dc7cba7a45f";
	// master API Key for dev
	// private static final String apiKey = "5c0a9482-930f-49d8-a319-ea3d24081ad2";
	
    public static void main( String[] args ) {
    	System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
    	Logging.enable();
    	// ShipperAccountExample.get();
    	// ShipperAccountExample.getOne();
    	// ShipperAccountExample.createAndDelete();
    	// ShipperAccountExample.getAsync();
    	// ShipperAccountExample.get();
    	// ShipperAccountExample.getMap();
    	// ShipperAccountExample.getRaw();
    	
    	// LabelExample.create();
    	// LabelExample.getOne();
    	// LabelExample.get();
    	
    	// RateExample.calculate();
    	// RateExample.get();
    	// RateExample.getOne();
    	
    	// CancelLabelExample.cancel();
    	// CancelLabelExample.get();
    	// CancelLabelExample.getOne();
    	
    	// ManifestExample.manifest();
    }
    
}
