package br.imd.pds.exceptions;

public class ExistentObjectException extends Exception
{
	public ExistentObjectException() {
        super();
	}

	public ExistentObjectException(String message) {
        super(message);
	}
}
