package org.hardcoders.socialapp.rest.views;

public class VPoint {
	String pointName;
	Boolean active;
	String cssClassname;
	
	public VPoint(String name, Boolean active) {
		super();
		this.pointName = name;
		this.active = active;
		this.cssClassname = "";
	}
	
	public VPoint(String name, Boolean active, String cssClassname) {
		super();
		this.pointName = name;
		this.active = active;
		this.cssClassname = cssClassname;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String name) {
		this.pointName = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCssClassname() {
		return cssClassname;
	}

	public void setCssClassname(String cssClassname) {
		this.cssClassname = cssClassname;
	}
	
	
}
