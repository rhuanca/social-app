package org.hardcoders.socialapp.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: milton.loayza@gmail.com
 * Date: 12/6/12 10:55 PM
 */
public class AlertQueue {
    public final String threadName = "AlertThread";

    private static AlertQueue _instance;

    private List<Alert> processQueue =  Collections.synchronizedList(new ArrayList<Alert>());

    public static AlertQueue getInstance() {
        if(_instance == null){
            synchronized(AlertQueue.class){
                if(_instance == null)
                    _instance = new AlertQueue();
            }
        }
        return _instance;
    }

    private AlertQueue() {
    }

    public synchronized void addProcess(Alert alert) {
        int eventsQueueSize = getProcessQueueSize();
        if (eventsQueueSize < 1) {
            processQueue =  Collections.synchronizedList(new ArrayList<Alert>());  // help GC to recover memory
            processQueue.add(alert);
            AlertProcess process = new AlertProcess();
            process.setName(threadName);
            process.start();
        } else {
            processQueue.add(alert);
        }
    }

    public synchronized Alert getFirstElement() {
        return processQueue.get(0);
    }

    public synchronized void removeFirstElement() {
        if (!processQueue.isEmpty()) {
            processQueue.remove(0);
        }
    }

    public synchronized int getProcessQueueSize() {
        return processQueue.size();
    }
}
