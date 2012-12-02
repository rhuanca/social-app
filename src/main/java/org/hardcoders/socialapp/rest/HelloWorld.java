package org.hardcoders.socialapp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.hardcoders.socialapp.model.Conflicto;
import org.hardcoders.socialapp.services.ConflictoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("/test")
@Controller
public class HelloWorld {
	private static Logger LOG = Logger.getLogger(HelloWorld.class); 

	ConflictoService conflictoService;
	
	@Autowired
	public void setConflictoService(ConflictoService conflictoService) {
		this.conflictoService = conflictoService;
	}

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public Response sayHello() {
		LOG.info("called sayHello()");
		return Response.status(200).entity("Hello World" ).build();
	}

	@POST
	@Path("/json")
	@Produces("application/json")
	public Response sendJson() {
		return Response.ok("{\"property1\":\"value1\"}").build();
	}

	@GET
	@Path("/count")
	@Produces("text/plain")
	public Response countConflictos() {
		LOG.info("called sayHello()");
		return Response.status(200).entity(conflictoService.countAll()).build();
	}
	
	@POST
	@Path("/list")
	@Produces("application/json")
	public List<Conflicto> listConflictos() {
		List<Conflicto> all = conflictoService.listAll();
		return all;
	}
}
