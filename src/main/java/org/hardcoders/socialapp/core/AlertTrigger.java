package org.hardcoders.socialapp.core;

/**
 * User: milton.loayza@gmail.com
 * Date: 12/7/12 12:54 AM
 */
public class AlertTrigger {

    public static void fireAlert(long conflictId) {
        Alert alert = new Alert();
        alert.setConflictId(conflictId);
        AlertQueue.getInstance().addProcess(alert);
    }

}
