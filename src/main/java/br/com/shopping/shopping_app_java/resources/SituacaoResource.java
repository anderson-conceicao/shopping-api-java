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

import br.com.shopping.shopping_app_java.model.Situacao;
import br.com.shopping.shopping_app_java.services.SituacaoService;


@Path("/situacao")
public class SituacaoResource {
	
	SituacaoService situacaoService = new SituacaoService();

	

	@GET
	@Produces("application/json;charset=utf-8")
	public Response getAllSituacao() {
		List<Situacao> listaSituacao = situacaoService.getAllSituacao();
		return Response.ok(listaSituacao).build();
	}

	@GET
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response getSituacao(@PathParam("id") Long id)  {
		Situacao obj = situacaoService.getSituacao(id);		
			return Response.ok(obj).build();
	}
	
	@POST
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
		public Response saveSituacao(Situacao situacao) {
		Situacao obj=situacaoService.saveSituacao(situacao);
		return  Response.status(Status.CREATED).entity(obj).build();
	}
	
	@PUT
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")
	public Response updateSituacao(@PathParam("id") Long id, Situacao situacao) {
		situacaoService.updateSituacao(id,situacao);
		return Response.noContent().build();
		
	}

	
	@DELETE
	@Produces("application/json;charset=utf-8")
	@Path("/{id}")	
	public Response deleteSituacao(@PathParam("id") Long id){
		situacaoService.deleteSituacao(id);
		return Response.noContent().build();
				
	}
}
