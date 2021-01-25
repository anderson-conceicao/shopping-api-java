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

import br.com.shopping.shopping_app_java.model.Situacao;
import br.com.shopping.shopping_app_java.services.SituacaoService;

@Path("/situacao")
public class SituacaoResource {
	
	SituacaoService situacaoService = new SituacaoService();

	Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSituacao() {
		List<Situacao> listaSituacao = situacaoService.getAllSituacao();
		return gson.toJson(listaSituacao);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public String saveSituacao(Situacao situacao) {
		return situacaoService.saveSituacao(situacao);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterar/{id}")
	public String Alterar(@PathParam("id") Long id, Situacao situacao){
		return situacaoService.updateSituacao(id,situacao);
		
	}

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/excluir/{id}")	
	public String Excluir(@PathParam("id") Long id){
		return situacaoService.deleteSituacao(id);
	}
 
}
