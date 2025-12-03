/*
 * Marvin Million
 */
public class DivideByZero extends Exception
{
	public DivideByZero()
	{
		super("Tried to divide by zero");
	}
	public DivideByZero(String msg)
	{
		super(msg);
	}
}
