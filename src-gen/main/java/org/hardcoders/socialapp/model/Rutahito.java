package org.hardcoders.socialapp.model;
// Generated Dec 8, 2012 12:21:54 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rutahito generated by hbm2java
 */
@Entity
@Table(name="rutahito"
    ,catalog="socialapp"
)
public class Rutahito  implements java.io.Serializable {


     private long id;
     private String name;
     private String zone;
     private Float mapX;
     private Float mapY;
     private Integer ratio;
     private Integer zoom;
     private String city;

    public Rutahito() {
    }

	
    public Rutahito(long id) {
        this.id = id;
    }
    public Rutahito(long id, String name, String zone, Float mapX, Float mapY, Integer ratio, Integer zoom, String city) {
       this.id = id;
       this.name = name;
       this.zone = zone;
       this.mapX = mapX;
       this.mapY = mapY;
       this.ratio = ratio;
       this.zoom = zoom;
       this.city = city;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="zone")
    public String getZone() {
        return this.zone;
    }
    
    public void setZone(String zone) {
        this.zone = zone;
    }
    
    @Column(name="mapX", precision=12, scale=0)
    public Float getMapX() {
        return this.mapX;
    }
    
    public void setMapX(Float mapX) {
        this.mapX = mapX;
    }
    
    @Column(name="mapY", precision=12, scale=0)
    public Float getMapY() {
        return this.mapY;
    }
    
    public void setMapY(Float mapY) {
        this.mapY = mapY;
    }
    
    @Column(name="ratio")
    public Integer getRatio() {
        return this.ratio;
    }
    
    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }
    
    @Column(name="zoom")
    public Integer getZoom() {
        return this.zoom;
    }
    
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }
    
    @Column(name="city")
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }




}


