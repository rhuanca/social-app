package org.hardcoders.socialapp.model;
// Generated Dec 2, 2012 1:31:00 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RutaHito generated by hbm2java
 */
@Entity
@Table(name="rutaHito"
    ,catalog="socialapp"
)
public class RutaHito  implements java.io.Serializable {


     private long id;
     private String name;
     private String zone;
     private String mapX;
     private String mapY;
     private String ratio;
     private String zoom;

    public RutaHito() {
    }

	
    public RutaHito(long id) {
        this.id = id;
    }
    public RutaHito(long id, String name, String zone, String mapX, String mapY, String ratio, String zoom) {
       this.id = id;
       this.name = name;
       this.zone = zone;
       this.mapX = mapX;
       this.mapY = mapY;
       this.ratio = ratio;
       this.zoom = zoom;
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
    
    @Column(name="mapX")
    public String getMapX() {
        return this.mapX;
    }
    
    public void setMapX(String mapX) {
        this.mapX = mapX;
    }
    
    @Column(name="mapY")
    public String getMapY() {
        return this.mapY;
    }
    
    public void setMapY(String mapY) {
        this.mapY = mapY;
    }
    
    @Column(name="ratio")
    public String getRatio() {
        return this.ratio;
    }
    
    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
    
    @Column(name="zoom")
    public String getZoom() {
        return this.zoom;
    }
    
    public void setZoom(String zoom) {
        this.zoom = zoom;
    }




}

