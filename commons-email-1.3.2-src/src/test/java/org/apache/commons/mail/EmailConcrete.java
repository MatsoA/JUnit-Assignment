package org.apache.commons.mail;

import java.util.Map;

public class EmailConcrete extends Email {
	
	@Override
	public Email setMsg(String msg) throws EmailException {
		//TODO Implement
		return null;
	}
	
	/**
	* @return headers 
	*/
	public Map<String, String> getHeaders()
	{
		return this.headers;
	}
	public String getContentType()
	{
		return this.getContentType();
	}
}
