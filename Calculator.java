/*
 * Marvin Million
 */
import java.util.Scanner;
public class Calculator {
	private double result;
	public static final double PREC = 0.0001;
	
	public static void main(String[] args) 
	{
		//double i = PREC; can do because static
		//double j = result; Cant do because not static too
		Calculator calc = new Calculator();
		//don't need a default constructor because every class is an object so all values (if not default) are already set to 0
		System.out.println("Welcome to the Calculator!\n"
				+ "Format each line\n"
				+ "<<operator>> <<number>>\n"
				+ "For example \"+ 3\"\n"
				+ "To quit enter 'e'");
		calc.runCalculator();
		System.out.println("Goodbye");
	}
	public void runCalculator()
	{
		Scanner keyboard = new Scanner(System.in);
		boolean done = false;
		this.result = 0.0;
		System.out.println("Result:" +this.result);
		while(!done)
		{
			//if next and then "+ 3" it goes all the way until the space
			//- 4
			//* 5 
			//Extract Operator
			char nextOp= (keyboard.next()).charAt(0);
			if(nextOp=='e')
			{
				done = true;
			}
			//Extract Number
			double nextNumber = keyboard.nextDouble();
			try
			{
				this.result = evaluate(nextOp,this.result,nextNumber);
				System.out.println(this.result);
			}
			catch(DivideByZero e)
			{
				e.printStackTrace();
			}
			catch(UnknownOperatorException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public double evaluate(char op,double n1, double n2)
	throws DivideByZero, UnknownOperatorException
	//only throws in method declaration
	{
		//Any method with non-void return type then:
		//double answer=0.0;
		//return answer
		//And then fill in middle
		double answer=0.0;
		switch(op)
		{
		case '+':
			answer = n1+n2;
			break;
		case '-':
			answer = n1-n2;
			break;
		case '*':
			answer = n1*n2;
			break;
		case '/':
			if((-PREC<n2)&&(n2<PREC))
				throw new DivideByZero();
			answer = n1/n2;
			break;
		default:
			throw new UnknownOperatorException(op+" was used!");
		}
		return answer;
	}
}
