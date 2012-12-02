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
	String latitude;
	String longitude;
	String name;
	String id;
	String zoneZoom;
	String zoneName;
	String zoneLatitude;
	String zoneLongitude;
	
	public VPointMap() {
		super();
	}
	
	public VPointMap(String latitude, String longitude, String name, String id,
			String zoneZoom, String zoneName, String zoneLatitude,
			String zoneLongitude) {
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZoneZoom() {
		return zoneZoom;
	}
	public void setZoneZoom(String zoneZoom) {
		this.zoneZoom = zoneZoom;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getZoneLatitude() {
		return zoneLatitude;
	}
	public void setZoneLatitude(String zoneLatitude) {
		this.zoneLatitude = zoneLatitude;
	}
	public String getZoneLongitude() {
		return zoneLongitude;
	}
	public void setZoneLongitude(String zoneLongitude) {
		this.zoneLongitude = zoneLongitude;
	}
}
