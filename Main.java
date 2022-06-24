import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */


class Main {
	public static void main(String[] args)
	{
    Magpie maggie = new Magpie();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
      System.out.print("User: ");
		String statement = in.nextLine();
		
		while (!statement.toUpperCase().equals("BYE"))
		{
			System.out.println("\nMagpie: " + maggie.getResponse(statement.toLowerCase()));
         System.out.print("User: ");
			statement = in.nextLine();
		}
	}
}