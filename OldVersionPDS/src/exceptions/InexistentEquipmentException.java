package exceptions;

public class InexistentEquipmentException extends Exception
{
	public InexistentEquipmentException()
	{
        super();
	}

	public InexistentEquipmentException(String message)
	{
        super(message);
	}
}
