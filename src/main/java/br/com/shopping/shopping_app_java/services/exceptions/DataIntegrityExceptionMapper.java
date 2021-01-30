package br.com.shopping.shopping_app_java.services.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.shopping.shopping_app_java.model.ErrorMessage;
@Provider
public class DataIntegrityExceptionMapper implements ExceptionMapper<DataIntegrityException> {

	@Override
	public Response toResponse(DataIntegrityException exception) {
		ErrorMessage errorMessage= new ErrorMessage(400, "Integridade de dados"+" - "+exception.getMessage());
		return Response.status(Status.BAD_REQUEST)
				  .entity(errorMessage)
				  .build();
	}
}
