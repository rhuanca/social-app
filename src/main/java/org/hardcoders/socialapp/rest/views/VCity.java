package org.hardcoders.socialapp.rest.views;

import java.util.ArrayList;
import java.util.Collection;

public class VCity {
	String cityName;
	Collection<VZone> zones = new ArrayList<VZone>();
	
	public VCity() {
		super();
	}
	

	public VCity(String name) {
		super();
		this.cityName = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String name) {
		this.cityName = name;
	}

	public Collection<VZone> getZones() {
		return zones;
	}

	public void setZones(Collection<VZone> zones) {
		this.zones = zones;
	}
	
	public VZone addZone(VZone zone) {
		this.zones.add(zone);
		return zone;
	}
	
	
	
	

}
