package com.swaggerwith.spring.model;

import javax.persistence.*;
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int mapId;
	private  String longitude;

	private String latitude;
	private String mapLocation;
	
	
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMapLocation() {
		return mapLocation;
	}
	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}
	@Override
	public String toString() {
		return "Location [mapId=" + mapId + ", longitude=" + longitude + ", latitude=" + latitude + ", mapLocation="
				+ mapLocation + "]";
	}
	public Location(int mapId, String longitude, String latitude, String mapLocation) {
		super();
		this.mapId = mapId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.mapLocation = mapLocation;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
