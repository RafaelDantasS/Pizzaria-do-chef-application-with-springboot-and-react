package br.com.pizzaDoChef.excepitions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundEXception extends RuntimeException {

	private static final long serialVersionUID = 1L;	
	
	public ResourceNotFoundEXception(String ex) {
		super(ex);
		
	}



	
}
