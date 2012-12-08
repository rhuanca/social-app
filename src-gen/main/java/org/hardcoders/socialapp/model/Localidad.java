package org.hardcoders.socialapp.model;
// Generated Dec 8, 2012 12:21:54 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Localidad generated by hbm2java
 */
@Entity
@Table(name="localidad"
    ,catalog="socialapp"
)
public class Localidad  implements java.io.Serializable {


     private double id;
     private Double provinceId;
     private String name;

    public Localidad() {
    }

	
    public Localidad(double id) {
        this.id = id;
    }
    public Localidad(double id, Double provinceId, String name) {
       this.id = id;
       this.provinceId = provinceId;
       this.name = name;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, precision=22, scale=0)
    public double getId() {
        return this.id;
    }
    
    public void setId(double id) {
        this.id = id;
    }
    
    @Column(name="provinceId", precision=22, scale=0)
    public Double getProvinceId() {
        return this.provinceId;
    }
    
    public void setProvinceId(Double provinceId) {
        this.provinceId = provinceId;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


