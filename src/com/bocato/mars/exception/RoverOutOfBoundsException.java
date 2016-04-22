package com.bocato.mars.exception;

public class RoverOutOfBoundsException extends RuntimeException{
	
	public RoverOutOfBoundsException(String string) {
		super(string);
	}
	
	public RoverOutOfBoundsException() {
		super("A sonda está fora dos limites do Plateau.");
	}

	private static final long serialVersionUID = -4311096320283943927L;
	
}
