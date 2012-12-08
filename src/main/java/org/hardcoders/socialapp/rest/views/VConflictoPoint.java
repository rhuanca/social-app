package org.hardcoders.socialapp.rest.views;

import org.springframework.web.util.HtmlUtils;

public class VConflictoPoint {
	int radious;
	int level;
	String tooltip;
	double latitude;
	double longitude;
	String name;
	String description;

	long id;
	int zoneZoom;
	String zoneName;
	double zoneLatitude;
	double zoneLongitude;
	
	public VConflictoPoint() {
		super();
	}
	
	public VConflictoPoint(int radious, int level, String tooltip,
			double latitude, double longitude, String name, 
			String descriptio, int id,
			int zoneZoom, String zoneName, double zoneLatitude,
			double zoneLongitude) {
		super();
		this.radious = radious;
		this.level = level;
		this.tooltip = tooltip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.id = id;
		this.zoneZoom = zoneZoom;
		this.zoneName = zoneName;
		this.zoneLatitude = zoneLatitude;
		this.zoneLongitude = zoneLongitude;
	}

	public int getRadious() {
		return radious;
	}
	public void setRadious(int ratio) {
		this.radious = ratio;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTooltip() {
		return HtmlUtils.htmlEscape(tooltip);
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return HtmlUtils.htmlEscape(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(Long long1) {
		this.id = long1;
	}
	public int getZoneZoom() {
		return zoneZoom;
	}
	public void setZoneZoom(int zoneZoom) {
		this.zoneZoom = zoneZoom;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getZoneLatitude() {
		return zoneLatitude;
	}
	public void setZoneLatitude(double zoneLatitude) {
		this.zoneLatitude = zoneLatitude;
	}
	public double getZoneLongitude() {
		return zoneLongitude;
	}
	public void setZoneLongitude(double zoneLongitude) {
		this.zoneLongitude = zoneLongitude;
	}
}
