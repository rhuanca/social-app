package org.hardcoders.socialapp.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.hardcoders.socialapp.core.AlertTrigger;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.model.Rutahito;
import org.hardcoders.socialapp.model.Userroute;
import org.hardcoders.socialapp.rest.views.VCity;
import org.hardcoders.socialapp.rest.views.VConflictoPoint;
import org.hardcoders.socialapp.rest.views.VConflictsList;
import org.hardcoders.socialapp.rest.views.VPoint;
import org.hardcoders.socialapp.rest.views.VZone;
import org.hardcoders.socialapp.services.ConflictoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Path("/conflicts")
@Controller
public class ConflictoRestService {
	
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
		return Response.ok(gson.toJson(getConflictosList())).build();
	}
	
	@POST
	@Path("/listRutaHitos")
	@Produces("application/json")
	public Response listRutaHitos() {
		Gson gson = new Gson();		
		List<Rutahito> listAllRutaHitos = conflictoService.listAllRutaHitos();
		return Response.ok(gson.toJson(listAllRutaHitos)).build();
	}
	
	@POST
	@Path("/createConflict")
	@Produces("application/json")
	public Response createConflict(@FormParam("rutaHitoId")String rutaHitoId, 
			@FormParam("detail") String detail) {
		// search ruta hito
		
		Conflicto conflicto = new Conflicto();
		
		conflicto.setHora(new Date());
		
		Rutahito rutaHito = conflictoService.findRutaById(rutaHitoId);
		conflicto.setName(rutaHito.getName());
		conflicto.setDemanda(detail);
		conflicto.setMapX(rutaHito.getMapX());
		conflicto.setMapY(rutaHito.getMapY());
		conflicto.setLugar(rutaHito.getName());
		conflicto.setHitoId(rutaHito.getId());
		conflicto.setZone(rutaHito.getZone());
		conflicto.setCity(rutaHito.getCity());
		conflicto.setRatio(rutaHito.getRatio());
	
		long id = conflictoService.insert(conflicto);
        if (id > 0) {
            AlertTrigger.fireAlert(id);  // fire alert
        }

		return Response.ok(new Gson().toJson("{\"success\":"+(id>0?true:false)+"}")).build();
    }
	
	
	
	@POST
	@Path("/listConflictosMap")
	@Produces("application/json")
	public Response listConflicts() {
		return Response.ok(new Gson().toJson(getConflictsMap())).build();
    }	
	
	@POST
	@Path("/createAlertPoint")
	@Produces("application/json")
	public Response createAlertPoint(@FormParam("alertHito")String alertHito) {
		Userroute userroute = new Userroute();
		userroute.setP1(Long.valueOf(alertHito));
		userroute.setAlertType("P");
		long id = conflictoService.insertAlert(userroute);
		return Response.ok(new Gson().toJson("{\"success\":"+(id>0?true:false)+"}")).build();
    }
	
	@POST
	@Path("/createAlertRoute")
	@Produces("application/json")

	public Response createAlertRoute(
			@Context HttpServletRequest request,
			@FormParam("point1")String point1,
			@FormParam("point2")String point2,
			@FormParam("googleRoute")String googleRoute
			) {
		Userroute userroute = new Userroute();
		userroute.setP1(Long.valueOf(point1));
		userroute.setP2(Long.valueOf(point2));
		userroute.setAlertType("R");
		userroute.setGoogleRoute(googleRoute);
		Long userId = (Long) request.getSession().getAttribute("userId");
		if(userId != null) {
			userroute.setUserId(userId);
		} else {
			System.out.println("creating route to default user.");
			userroute.setUserId(1l);
		}
		
		
		long id = conflictoService.insertAlert(userroute);
		return Response.ok(new Gson().toJson("{\"success\":"+(id>0?true:false)+"}")).build();
    }
	
	//
	// test service
	//
	private VConflictsList getConflictosList(){
		List<Conflicto> conflicts = GetLastConflicts();

		VConflictsList r = new VConflictsList();
		VCity city = new VCity("");
		VZone zone = new VZone("");
		for(int i=0; i<conflicts.size(); i++) {
			Conflicto conflicto = conflicts.get(i); 
			if(!city.getCityName().equals(conflicto.getCity())) {
				city = new VCity(conflicto.getCity());
				// zone = new VZone(conflicto.getZone());
				r.addCity(city);
				//city.addZone(zone);
			}
			
			if(!zone.getZoneName().equals(conflicto.getZone())) {
				zone = new VZone(conflicto.getZone());
				city.addZone(zone);
			}
			zone.addPoint(new VPoint(conflicto.getLugar() + ": " + conflicto.getDemanda(), false));
		}
		return r;
	}

	private List<Conflicto> GetLastConflicts() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(Calendar.HOUR_OF_DAY, -1);
		List<Conflicto> conflicts = conflictoService.findLastConflict(gc.getTime());
		return conflicts;
	}
	
	//
	// Lista conflictos for map
	//
	private Collection<VConflictoPoint> getConflictsMap(){
		
		List<Conflicto> conflicts = GetLastConflicts();
		Collection<VConflictoPoint> r = new ArrayList<VConflictoPoint>();
		for(int i=0; i<conflicts.size(); i++) {
			Conflicto conflicto = conflicts.get(i); 
			Rutahito hito = conflictoService.findRutaById(conflicto.getHitoId());
			VConflictoPoint point = new VConflictoPoint();
			point.setRadious(200);
			point.setLevel(5);
			point.setTooltip(conflicto.getName());
			point.setLatitude(conflicto.getMapX());
			point.setLongitude(conflicto.getMapY());
			point.setName(conflicto.getName());
			point.setDescription(conflicto.getDemanda());
			point.setId(conflicto.getId());
			point.setZoneZoom(hito.getZoom());
			point.setZoneName(hito.getName());
			point.setZoneLatitude(hito.getMapY());
			point.setZoneLongitude(hito.getMapX());
			r.add(point);
		}
		return r;
	}
}


//r.add(new VConflictoPoint(ratio, level, tooltip, 							   												    		latitude,  	  longitude,     name, 								       									     id,  zoneZoom, zoneName,            		zoneLatitude, zoneLongitude))
//r .add(new VConflictoPoint(	, level, tooltip, latitude, longitude, name, id, zoneZoom, zoneName, zoneLatitude, zoneLongitude)
/*r.add(new VConflictoPoint(  200,   5,   "Exigen el mejoramiento de caminos y el asfaltado de la via Avircato - Carreras.",    		-16.529664d, -68.091481d,  "Sindicato de Transporte Rio Abajo",        									 1, 16,     "La Paz - Zona Sur", 		-16.529664, -68.091481));
r.add(new VConflictoPoint(  200,   4,   "Exigen la construccin de la carretera La Paz-Cochabamba.",    								-16.541333, -68.091481,  "Pobladores de comunidades \"Rio Abajo\"",  									 1, 15,     "La Paz - Zona Sur", 		-16.541333, -68.091481));
r.add(new VConflictoPoint(  300,   3,   "Exigen el asfaltado de la va Avircato - Carreras y la electrificacion de la zona.",    		-16.529664, -68.091481,  "Campesinos de \"Rio Abajo\"",  									 			 1, 16,     "La Paz - Zona Sur", 		-16.529664, -68.091481));
r.add(new VConflictoPoint(  300,   2,   "Rechazo a la intervencion de la empresa.", 													-16.502329, -68.132588,  "Trabajadores de la Empresa Rural de Energa Elctrica de La Paz (Emprelpaz)",    1, 12,     "La Paz - Zona Central",   -16.502329, -68.132588));
r.add(new VConflictoPoint(  500,   1,   "Demanda de terrenos para vivir y justifican el avasallamiento de terrenos en esta ciudad.", 	-16.503507, -68.16206,   "Familias del Movimiento Sin Tierra", 										     1, 12,     "El Alto - Zona Norte",     -16.503507, -68.16206));*/
