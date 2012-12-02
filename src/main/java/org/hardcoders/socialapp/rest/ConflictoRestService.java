package org.hardcoders.socialapp.rest;

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
	
	
	
	//
	// test service
	//
	private VConflictsList getList(){
		VConflictsList r = new VConflictsList();
		VCity city1 = new VCity("La Paz");
		city1.addZone(new VZone("Zona Sur"))
			.addPoint(new VPoint("Av. Ballivian", true, "active"))
			.addPoint(new VPoint("Calle Federico Zuaso", false));
		
		city1.addZone(new VZone("Zona Norte"))
			.addPoint(new VPoint("Cementerio General", false))
			.addPoint(new VPoint("Plaza Garita del Lima", false));
		
		r.addCity(city1);
		
		VCity city2 = new VCity("El Alto");
		city2.addZone(new VZone("Zona Norte"))
			.addPoint(new VPoint("Av 6 de Agosto", true, ""));
		r.addCity(city2);
		return r;
	}
	
}
