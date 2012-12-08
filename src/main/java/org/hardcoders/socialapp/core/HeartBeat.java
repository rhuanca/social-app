package org.hardcoders.socialapp.core;

import java.util.Date;

public class HeartBeat {
	String message;
	Date time;
	public HeartBeat(String message, Date time) {
		super();
		this.message = message;
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
	@Override
	public String toString() {
		return time + " - " +message;
	}
	
}
