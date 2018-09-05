package br.com.facilitando.imagem.controller.exception;

import br.com.facilitando.imagem.domain.ObjectNotFound;
import lombok.Getter;

@Getter
public class ObjectNotFountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	private ObjectNotFound object;
	
	public ObjectNotFountException(ObjectNotFound object) {
		super();
		this.object = object;
	}
	
	public ObjectNotFountException() {
		super();
	}
}
