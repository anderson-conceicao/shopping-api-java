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

import com.google.gson.Gson;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.services.LojaService;

@Path("/lojas")
public class LojaResource {

	LojaService lojaService = new LojaService();

	Gson gson = new Gson();

	@GET
	@Produces("application/json;charset=utf-8")
	public Response getAllLoja() {
		List<Loja> listaLoja = lojaService.getAllLoja();	
		
			return Response.ok(listaLoja).build();
	}

	@POST
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	@Path("/cadastrar")
	public String saveLoja(Loja loja) {
		System.out.println("ssssssssssssss"+loja.toString());
		return lojaService.saveLoja(loja);
	}

	@PUT
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	@Path("/alterar/{id}")
	public String Alterar(@PathParam("id") Long id, Loja loja) {
		return lojaService.updateLoja(id, loja);

	}

	@DELETE
	@Produces("application/json;charset=utf-8")
	@Path("/excluir/{id}")
	public String Excluir(@PathParam("id") Long id) {
		return lojaService.deleteLoja(id);
	}

}
