package br.com.shopping.shopping_app_java.services.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.shopping.shopping_app_java.model.ErrorMessage;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
		public Response toResponse(NotFoundException exception) {	
		ErrorMessage errorMessage= new ErrorMessage(404, "Recurso Não Encontrado");
		return Response.status(Status.NOT_FOUND)
				  .entity(errorMessage)
				  .build();
	}

}
