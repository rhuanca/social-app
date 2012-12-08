package org.hardcoders.socialapp.core;

import java.util.ArrayList;
import java.util.List;

public class HeartBeatJob implements Runnable {
	List<HeartBeatListener> listeners = new ArrayList<HeartBeatListener>();
	
	private static HeartBeatJob instance;
	
	private HeartBeatJob() {
	}
	
	public static HeartBeatJob getIntance() {
		if(instance == null) {
			instance = new HeartBeatJob();
		}
		return instance;
	}

	public void addHeartBeatListener(HeartBeatListener listener) {
		listeners.add(listener);
	}
	
	@SuppressWarnings("unused")
	private void sendHeartBeat(HeartBeat  beat) {
		System.out.println("Sending heart beat to " + listeners.size() + " listeners.");
		for(int i=0; i<listeners.size(); i++) {
			listeners.get(i).handleHeartBeat(beat);
		}
	}
	
	@Override
	public void run() {
		/*while(true) {
			sendHeartBeat(new HeartBeat("I'm alive", new Date()));
			try {
				Thread.sleep(5*1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
}
