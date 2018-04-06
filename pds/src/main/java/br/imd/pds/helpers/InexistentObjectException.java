package br.imd.pds.helpers;

public class InexistentObjectException extends Exception
{
	public InexistentObjectException() {
        super();
	}

	public InexistentObjectException(String message) {
        super(message);
	}
}
