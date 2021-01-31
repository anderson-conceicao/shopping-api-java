package br.com.shopping.shopping_app_java.resources;


import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.model.dtos.LojaDTO;
import br.com.shopping.shopping_app_java.services.LojaService;

@Path("/lojas")
public class LojaResource {

	LojaService lojaService = new LojaService();

	@GET
	@Produces("application/json;charset=utf-8")
	public Response getAllLoja() {
		List<LojaDTO> listaLoja = lojaService.getAllLoja();		
			return Response.ok(listaLoja).build();
	}
	
	@GET
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response getLoja(@PathParam("id") Long id){
		Loja obj = lojaService.getLoja(id);		
			return Response.ok(obj).build();
	}

	@POST
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	public Response saveLoja(Loja loja) {
	Loja obj=lojaService.saveLoja(loja);
			return  Response.status(Status.CREATED).entity(obj).build();
	}

	@PUT
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response updateLoja(@PathParam("id") Long id, Loja loja)  {
		lojaService.updateLoja(id, loja);
		return Response.noContent().build(); 

	}

	@DELETE
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response deleteLoja(@PathParam("id") Long id){
		lojaService.deleteLoja(id);		
		return Response.noContent().build();
				
	}

}
