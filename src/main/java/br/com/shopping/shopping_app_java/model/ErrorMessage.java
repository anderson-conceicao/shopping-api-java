package br.com.shopping.shopping_app_java.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ErrorMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int erroCode;
	private String erroMessage;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(int erroCode, String erroMessage) {
		super();
		this.erroCode = erroCode;
		this.erroMessage = erroMessage;
	}
	public int getErroCode() {
		return erroCode;
	}
	public void setErroCode(int erroCode) {
		this.erroCode = erroCode;
	}
	public String getErroMessage() {
		return erroMessage;
	}
	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}
	
	
	
	

}
