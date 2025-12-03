/*
 * Marvin Million
 */
public class UnknownOperatorException extends Exception
{
	public UnknownOperatorException()
	{
		super("Tried to use an unknown operator");
	}
	public UnknownOperatorException(String msg)
	{
		super(msg);
	}
}
