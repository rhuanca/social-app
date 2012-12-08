package org.hardcoders.socialapp.core;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.User;
import org.hardcoders.socialapp.services.ConflictoService;
import org.hardcoders.socialapp.services.UserService;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * User: milton.loayza@gmail.com
 * Date: 12/6/12 11:56 PM
 */
public class AlertProcess extends Thread {

    @Override
    public void run() {

        while (AlertQueue.getInstance().getProcessQueueSize() > 0) {
            Alert alert = AlertQueue.getInstance().getFirstElement();
            try {
                sendAlert(alert);
                alert = null;    // help GC to recover memory

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                AlertQueue.getInstance().removeFirstElement();

            }
        }
    }

    private void sendAlert(Alert alert) {
        System.out.println("Sending alert "+ alert.getConflictId());
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        ConflictoService conflictoService =  applicationContext.getBean(ConflictoService.class);

        Conflicto conflicto = conflictoService.findById(alert.getConflictId());
        UserService userService = applicationContext.getBean(UserService.class);

         // decide which user match the conflict
        List<User> users = userService.getUserByAffectedConflicto(conflicto.getId());
        for (User user : users) {
            if (user.getSendByEmail()) {
                sendByEmail(user, conflicto);
            }
            if (user.getSendByMobile()) {
                sendByMobile(user, conflicto);
            }
            if (user.getSendByTweeter()) {
                sendByTweeter(user, conflicto);
            }

        }
    }

    private void sendByEmail(User user, Conflicto conflicto) {
        try {
            HttpClient httpClient = new HttpClient();
            PostMethod postMethod = new PostMethod("http://loayza.org/mail/sendEmail.php");
            postMethod.addParameter("email", user.getEmail());
            postMethod.addParameter("content", conflicto.getName());
            httpClient.executeMethod(postMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendByMobile(User user, Conflicto conflicto) {
        //To change body of created methods use File | Settings | File Templates.
    }
    private void sendByTweeter(User user, Conflicto conflicto) {
        //To change body of created methods use File | Settings | File Templates.
    }


}
