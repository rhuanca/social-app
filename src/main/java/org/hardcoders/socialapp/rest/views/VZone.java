package org.hardcoders.socialapp.rest.views;

import java.util.ArrayList;
import java.util.Collection;

public class VZone {
	String zoneName;
	Collection<VPoint> points = new ArrayList<VPoint>();
	
	
	public VZone(String name) {
		super();
		this.zoneName = name;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String name) {
		this.zoneName = name;
	}

	public Collection<VPoint> getPoints() {
		return points;
	}

	public void setPoints(Collection<VPoint> points) {
		this.points = points;
	}
	
	public VZone addPoint(VPoint point) {
		this.points.add(point);
		return this;
	}
	
	
	
	

}
