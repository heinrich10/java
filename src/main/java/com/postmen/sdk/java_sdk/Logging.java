package com.postmen.sdk.java_sdk;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.api.client.http.HttpTransport;

public class Logging {
	public static void enable() {
		Logger logger = Logger.getLogger(HttpTransport.class.getName());
    	logger.setLevel(Level.ALL);
    	logger.addHandler(new Handler() {

			@Override
			public void publish(LogRecord record) {
				// TODO Auto-generated method stub
				if (record.getLevel().intValue() < Level.INFO.intValue()) {
					System.err.println(record.getMessage());
				}
				
			}

			@Override
			public void flush() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void close() throws SecurityException {
				// TODO Auto-generated method stub
				
			}
    		
    	});
	}
}
