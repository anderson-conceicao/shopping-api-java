package br.com.shopping.shopping_app_java.services.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataIntegrityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String message) {
		super(message);
		
	}

}
