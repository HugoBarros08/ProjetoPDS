package exceptions;

public class InexistentCharacteristicException extends Exception
{
	public InexistentCharacteristicException()
	{
        super();
	}

	public InexistentCharacteristicException(String message)
	{
        super(message);
	}
}
