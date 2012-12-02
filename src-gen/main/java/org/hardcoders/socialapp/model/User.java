package org.hardcoders.socialapp.model;
// Generated Dec 2, 2012 1:31:00 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="socialapp"
)
public class User  implements java.io.Serializable {


     private Long id;
     private String fullname;
     private String email;
     private String password;
     private String mobile;
     private String tweeter;

    public User() {
    }

    public User(String fullname, String email, String password, String mobile, String tweeter) {
       this.fullname = fullname;
       this.email = email;
       this.password = password;
       this.mobile = mobile;
       this.tweeter = tweeter;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="fullname")
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="password")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="mobile")
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="tweeter")
    public String getTweeter() {
        return this.tweeter;
    }
    
    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }




}

