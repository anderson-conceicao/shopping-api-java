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
	private String erroDate;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(int erroCode, String erroMessage,String erroDate) {
		super();
		this.erroCode = erroCode;
		this.erroMessage = erroMessage;
		this.erroDate = erroDate;
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
	public String getErroDate() {
		return erroDate;
	}
	public void setErroDate(String erroDate) {
		this.erroDate = erroDate;
	}
	
	
	
	

}
