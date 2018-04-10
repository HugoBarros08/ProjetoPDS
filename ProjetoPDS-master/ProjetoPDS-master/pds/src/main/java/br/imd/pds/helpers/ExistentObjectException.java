package br.imd.pds.helpers;

public class ExistentObjectException extends Exception
{
	public ExistentObjectException() {
        super();
	}

	public ExistentObjectException(String message) {
        super(message);
	}
}
