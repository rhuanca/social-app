package org.hardcoders.socialapp.rest.views;

import org.hardcoders.socialapp.model.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: AGutierrez6
 * Date: 12/7/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class VUser {

    private Long id;
    private String fullname;
    private String email;
    private String password;
    private String mobile;
    private String tweeter;
    private Boolean sendByEmail;
    private Boolean sendByMobile;
    private Boolean sendByTweeter;
    private String username;
    private String authentication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTweeter() {
        return tweeter;
    }

    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }

    public Boolean getSendByEmail() {
        return sendByEmail;
    }

    public void setSendByEmail(Boolean sendByEmail) {
        this.sendByEmail = sendByEmail;
    }

    public Boolean getSendByMobile() {
        return sendByMobile;
    }

    public void setSendByMobile(Boolean sendByMobile) {
        this.sendByMobile = sendByMobile;
    }

    public Boolean getSendByTweeter() {
        return sendByTweeter;
    }

    public void setSendByTweeter(Boolean sendByTweeter) {
        this.sendByTweeter = sendByTweeter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public static VUser getVUSer(User user) {
        VUser vUser = new VUser();
        vUser.setAuthentication(user.getAuthentication());
        vUser.setEmail(user.getEmail());
        vUser.setFullname(user.getFullname());
        vUser.setId(user.getId());
        vUser.setMobile(user.getMobile());
        vUser.setSendByEmail(user.getSendByEmail());
        vUser.setSendByMobile(user.getSendByMobile());
        vUser.setSendByTweeter(user.getSendByTweeter());
        return vUser;
    }
}
