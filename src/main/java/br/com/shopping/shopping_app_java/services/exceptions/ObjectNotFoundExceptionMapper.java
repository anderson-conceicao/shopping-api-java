package br.com.shopping.shopping_app_java.services.exceptions;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.shopping.shopping_app_java.model.ErrorMessage;

@Provider
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

	@Override
	public Response toResponse(ObjectNotFoundException exception) {
		
		Calendar c = Calendar.getInstance();
		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
		
		Date exceptionDate= c.getTime();
		
		
		ErrorMessage errorMessage= new ErrorMessage(404, "Objeto Não Encontrado"+" - "+exception.getMessage(),f.format(exceptionDate));
		return Response.status(Status.NOT_FOUND)
				  .entity(errorMessage)
				  .build();
	}

}
