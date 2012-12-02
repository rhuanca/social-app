package org.hardcoders.socialapp.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.RutaHito;
import org.hardcoders.socialapp.rest.views.VCity;
import org.hardcoders.socialapp.rest.views.VConflictoPoint;
import org.hardcoders.socialapp.rest.views.VConflictsList;
import org.hardcoders.socialapp.rest.views.VPoint;
import org.hardcoders.socialapp.rest.views.VPointMap;
import org.hardcoders.socialapp.rest.views.VZone;
import org.hardcoders.socialapp.services.ConflictoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Path("/conflicts")
@Controller
public class ConflictoRestService {
	
	private static final String POINT = "point";
	ConflictoService conflictoService;
	
	@Autowired
	public void setConflictoService(ConflictoService conflictoService) {
		this.conflictoService = conflictoService;
	}

	@POST
	@Path("/list")
	@Produces("application/json")
	public Response list() {
		Gson gson = new Gson();		
		return Response.ok(gson.toJson(getList())).build();
	}
	
	@POST
	@Path("/listRutaHitos")
	@Produces("application/json")
	public Response listRutaHitos() {
		Gson gson = new Gson();		
		List<RutaHito> listAllRutaHitos = conflictoService.listAllRutaHitos();
		return Response.ok(gson.toJson(listAllRutaHitos)).build();
	}
	
	@POST
	@Path("/createConflict")
	@Produces("application/json")
	public Response createConflict(@FormParam("type")String type, 
			@FormParam("rutaHitoId")String rutaHitoId, 
			@FormParam("detail") String detail) {
		// search ruta hito
		
		Conflicto conflicto = new Conflicto();
		conflicto.setName(detail);
		conflicto.setHora(new Date());
		
		if(POINT.equals(type)) {
			RutaHito rutaHito = conflictoService.findRutaById(rutaHitoId);
			conflicto.setMapX(rutaHito.getMapX());
			conflicto.setMapY(rutaHito.getMapY());
			conflicto.setLugar(rutaHito.getName());
		} else {
			
		}
		long id = conflictoService.insert(conflicto);
		return Response.ok(new Gson().toJson("{\"success\":"+(id>0?true:false)+"}")).build();
    }
	
	
	
	@POST
	@Path("/listConflictosMap")
	@Produces("application/json")
	public Response listConflicts() {
		return Response.ok(new Gson().toJson(getConflictsMap())).build();
    }
	
	@POST
	@Path("/getRuta")
	@Produces("application/json")
	public Response verRuta() {
		return Response.ok(new Gson().toJson(getRutaPoints())).build();
    }
	
	//
	// test service
	//
	private VConflictsList getList(){
		VConflictsList r = new VConflictsList();
		VCity city1 = new VCity("La Paz");
		city1.addZone(new VZone("Zona Sur"))
			.addPoint(new VPoint("Calle 17 Obrajes", true, "active"))
			.addPoint(new VPoint("Calle 8 Calacoto", false))
			.addPoint(new VPoint("Calle 17 Obrajes", false));
		
		city1.addZone(new VZone("Zona Central"))
			.addPoint(new VPoint("El Prado", false));
		
		r.addCity(city1);
		
		VCity city2 = new VCity("El Alto");
		city2.addZone(new VZone("Zona Norte"))
			.addPoint(new VPoint("La Ceja", true, ""));
		r.addCity(city2);
		return r;
	}
	
	//
	// Lista conflictos for map
	//
	private Collection<VConflictoPoint> getConflictsMap(){
		Collection<VConflictoPoint> r = new ArrayList<VConflictoPoint>();
		//r.add(new VConflictoPoint(ratio, level, tooltip, 							   												    		latitude,  	  longitude,     name, 								       									     id,  zoneZoom, zoneName,            		zoneLatitude, zoneLongitude))
		r.add(new VConflictoPoint(  "5",   "1",   "Exigen el mejoramiento de caminos y el asfaltado de la via Avircato - Carreras.",    		"-16.529664", "-68.091481",  "Sindicato de Transporte Rio Abajo",        									 "1", "16",     "La Paz - Zona Sur", 		"-16.529664", "-68.091481"));
		r.add(new VConflictoPoint(  "5",   "2",   "Exigen la construccin de la carretera La Paz-Cochabamba.",    								"-16.541333", "-68.091481",  "Pobladores de comunidades \"Rio Abajo\"",  									 "1", "15",     "La Paz - Zona Sur", 		"-16.541333", "-68.091481"));
		r.add(new VConflictoPoint(  "5",   "3",   "Exigen el asfaltado de la va Avircato - Carreras y la electrificacin de la zona.",    		"-16.529664", "-68.091481",  "Campesinos de \"Rio Abajo\"",  									 			 "1", "16",     "La Paz - Zona Sur", 		"-16.529664", "-68.091481"));
		r.add(new VConflictoPoint(  "5",   "3",   "Rechazo a la intervencin de la empresa.", 													"-16.502329", "-68.132588",  "Trabajadores de la Empresa Rural de Energa Elctrica de La Paz (Emprelpaz)",  "1", "12",     "La Paz - Zona Centreal",   "-16.502329", "-68.132588"));
		r.add(new VConflictoPoint(  "5",   "3",   "Demanda de terrenos para vivir y justifican el avasallamiento de terrenos en esta ciudad.", 	"-16.503507", "-68.16206",   "Familias del Movimiento Sin Tierra", 										     "1", "12",     "El Alto - Zona Norte",     "-16.503507", "-68.16206"));
		return r;
	}
	
	//
	// Lista de puntos ruta.
	// 
	private Collection<VPointMap> getRutaPoints(){
		Collection<VPointMap> r = new ArrayList<VPointMap>();
		// r.add(new VPointMap(latitude, longitude, name, id, zoneZoom, zoneName, zoneLatitude, zoneLongitude))
		r.add(new VPointMap("-16.496331", "-68.136569", "Perez Velasco", "13", "12", "Zona Central", "-16.496331", "-68.136569"));
		r.add(new VPointMap("-16.539132", "-68.078075", "San Miguel", "15", "18", "Zona Sur", "-16.539132", "-68.078075"));
		return r;
	}
}
