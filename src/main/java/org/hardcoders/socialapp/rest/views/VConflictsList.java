package org.hardcoders.socialapp.rest.views;

import java.util.ArrayList;
import java.util.Collection;

public class VConflictsList {
	Collection<VCity> cities = new ArrayList<VCity>();

	public VConflictsList() {
		super();
	}

	public Collection<VCity> getCities() {
		return cities;
	}

	public void setCities(Collection<VCity> cities) {
		this.cities = cities;
	}
	
	public void addCity(VCity city) {
		this.cities.add(city);
	}

	
	
	
}
