package com.myrealtor.service.external;

@Deprecated
public class Coordinate  {
	
	protected String latitude, longitude;
	
	
	public Coordinate(String latitude, String longitude) {	
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	
	public String getLongitude() {
		return longitude;
	}
	
	
	
}
