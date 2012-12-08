package org.hardcoders.socialapp.rest.views;

/*Point {
	  latitude
	  longitude
	  name
	  id
	  zoneZoom
	  zoneName
	  //optional
	  zoneLatitude
	  zoneLongitude  
	}
*/

public class VPointMap {
	double latitude;
	double longitude;
	String name;
	int id;
	int zoneZoom;
	String zoneName;
	double zoneLatitude;
	double zoneLongitude;
	
	public VPointMap() {
		super();
	}
	
	public VPointMap(double latitude, double longitude, String name, int id,
			int zoneZoom, String zoneName, double zoneLatitude,
			double zoneLongitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.id = id;
		this.zoneZoom = zoneZoom;
		this.zoneName = zoneName;
		this.zoneLatitude = zoneLatitude;
		this.zoneLongitude = zoneLongitude;
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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
