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
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.shopping.shopping_app_java.model.Segmento;
import br.com.shopping.shopping_app_java.services.SegmentoService;


@Path("/segmentos")
public class SegmentoResource {
	
	SegmentoService segmentoService = new SegmentoService();

	Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSegmento() {
		List<Segmento> listaSegmento = segmentoService.getAllSegmento();
		return gson.toJson(listaSegmento);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public String saveSegmento(Segmento segmento) {
		return segmentoService.saveSegmento(segmento);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterar/{id}")
	public String Alterar(@PathParam("id") Long id, Segmento segmento){
		return segmentoService.updateSegmento(id,segmento);
		
	}

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/excluir/{id}")	
	public String Excluir(@PathParam("id") Long id){
		return segmentoService.deleteSegmento(id);
	}
}