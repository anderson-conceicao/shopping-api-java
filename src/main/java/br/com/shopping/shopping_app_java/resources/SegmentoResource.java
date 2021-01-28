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


import br.com.shopping.shopping_app_java.model.Segmento;
import br.com.shopping.shopping_app_java.services.SegmentoService;


@Path("/segmentos")
public class SegmentoResource {
	
	SegmentoService segmentoService = new SegmentoService();

	

	@GET
	@Produces("application/json;charset=utf-8")
	public Response getAllSegmento() {
		List<Segmento> listaSegmento = segmentoService.getAllSegmento();
		return Response.ok(listaSegmento).build();
	}

	@GET
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response getSegmento(@PathParam("id") Long id)  {
		Segmento obj = segmentoService.getSegmento(id);		
			return Response.ok(obj).build();
	}
	
	@POST
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
		public Response saveSegmento(Segmento segmento) {
		Segmento obj=segmentoService.saveSegmento(segmento);
		return  Response.ok(obj).build();
	}
	
	@PUT
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response updateSegmento(@PathParam("id") Long id, Segmento segmento){
		segmentoService.updateSegmento(id,segmento);
		return Response.noContent().build();
		
	}

	
	@DELETE
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")	
	public Response deleteSegmento(@PathParam("id") Long id){
		segmentoService.deleteSegmento(id);
		return Response.noContent().build();
				
	}
}
