package com.postmen.sdk.java_sdk.model;

import com.google.api.client.util.Key;

public class ShipperAccountsResponse extends Response {
	@Key("data")
	private ShipperAccounts shipperAccounts;
	
	public void setShipperAccountsData(ShipperAccounts shipperAccounts) {
		this.shipperAccounts = shipperAccounts;
	}
	
	@Override
	public ShipperAccounts getData() {
		// TODO Auto-generated method stub
		return shipperAccounts;
	}
	
}
