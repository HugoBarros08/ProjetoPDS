package br.imd.pds.exceptions;

public class InexistentObjectException extends Exception
{
	public InexistentObjectException() {
        super();
	}

	public InexistentObjectException(String message) {
        super(message);
	}
}
