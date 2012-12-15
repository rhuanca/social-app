package org.hardcoders.socialapp.model;
// Generated Dec 8, 2012 12:21:54 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Conflicto generated by hbm2java
 */
@Entity
@Table(name="conflicto"
    ,catalog="socialapp"
)
public class Conflicto  implements java.io.Serializable {


     private Long id;
     private String name;
     private String actorDemandante;
     private String actorDemandado;
     private String sector;
     private Long localidad;
     private String demanda;
     private String sumary;
     private Date createdDate;
     private String ambito;
     private String alcance;
     private String medidaPresion;
     private String level;
     private String status;
     private String situacion;
     private String fuente;
     private Date startDate;
     private String ubicacion;
     private Date hora;
     private String lugar;
     private Float mapX;
     private Float mapY;
     private Integer ratio;
     private String city;
     private Long hitoId;
     private String zone;

    public Conflicto() {
    }

	
    public Conflicto(Date hora, String lugar) {
        this.hora = hora;
        this.lugar = lugar;
    }
    public Conflicto(String name, String actorDemandante, String actorDemandado, String sector, Long localidad, String demanda, String sumary, Date createdDate, String ambito, String alcance, String medidaPresion, String level, String status, String situacion, String fuente, Date startDate, String ubicacion, Date hora, String lugar, Float mapX, Float mapY, Integer ratio, String city, Long hitoId, String zone) {
       this.name = name;
       this.actorDemandante = actorDemandante;
       this.actorDemandado = actorDemandado;
       this.sector = sector;
       this.localidad = localidad;
       this.demanda = demanda;
       this.sumary = sumary;
       this.createdDate = createdDate;
       this.ambito = ambito;
       this.alcance = alcance;
       this.medidaPresion = medidaPresion;
       this.level = level;
       this.status = status;
       this.situacion = situacion;
       this.fuente = fuente;
       this.startDate = startDate;
       this.ubicacion = ubicacion;
       this.hora = hora;
       this.lugar = lugar;
       this.mapX = mapX;
       this.mapY = mapY;
       this.ratio = ratio;
       this.city = city;
       this.hitoId = hitoId;
       this.zone = zone;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="actorDemandante")
    public String getActorDemandante() {
        return this.actorDemandante;
    }
    
    public void setActorDemandante(String actorDemandante) {
        this.actorDemandante = actorDemandante;
    }
    
    @Column(name="actorDemandado")
    public String getActorDemandado() {
        return this.actorDemandado;
    }
    
    public void setActorDemandado(String actorDemandado) {
        this.actorDemandado = actorDemandado;
    }
    
    @Column(name="sector")
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    @Column(name="localidad")
    public Long getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(Long localidad) {
        this.localidad = localidad;
    }
    
    @Column(name="demanda")
    public String getDemanda() {
        return this.demanda;
    }
    
    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }
    
    @Column(name="sumary")
    public String getSumary() {
        return this.sumary;
    }
    
    public void setSumary(String sumary) {
        this.sumary = sumary;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdDate", length=0)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="ambito")
    public String getAmbito() {
        return this.ambito;
    }
    
    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }
    
    @Column(name="alcance")
    public String getAlcance() {
        return this.alcance;
    }
    
    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
    
    @Column(name="medidaPresion")
    public String getMedidaPresion() {
        return this.medidaPresion;
    }
    
    public void setMedidaPresion(String medidaPresion) {
        this.medidaPresion = medidaPresion;
    }
    
    @Column(name="level")
    public String getLevel() {
        return this.level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    @Column(name="status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="situacion")
    public String getSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
    
    @Column(name="fuente")
    public String getFuente() {
        return this.fuente;
    }
    
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="startDate", length=0)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Column(name="ubicacion")
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="hora", nullable=false, length=0)
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    @Column(name="lugar", nullable=false, length=120)
    public String getLugar() {
        return this.lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
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
    
    @Column(name="city")
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="hitoId")
    public Long getHitoId() {
        return this.hitoId;
    }
    
    public void setHitoId(Long hitoId) {
        this.hitoId = hitoId;
    }
    
    @Column(name="zone")
    public String getZone() {
        return this.zone;
    }
    
    public void setZone(String zone) {
        this.zone = zone;
    }




}

