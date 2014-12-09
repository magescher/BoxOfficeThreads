<<<<<<< HEAD
/**
 * @author Abigail Johnson
 * @author Carlos Rios
 * TA: Xander Morgan
 * Wednesday 4:30 pm 
 */
=======
// Authors: Abigail Johnson, Carlos Rios 
// EE422C-Assignment 6
>>>>>>> af5775a9fd8b6995bd33bbabbb50401764a45da2

package assignment6;

/**
 * Class to initialize critical objects and drive TicketBooth program 
 */
public class A6Driver 

{
	/**
	 * Main- Drives program
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		Theatre theatre = new Theatre();  
<<<<<<< HEAD
	
		Thread a = new Thread(new BoxOffice("Box Office A", theatre));
		Thread b = new Thread(new BoxOffice("Box Office B", theatre));
=======

		Runnable officeA = new BoxOffice("Box Office A", theatre);
		Runnable officeB = new BoxOffice("Box Office B", theatre);
	
		Thread a = new Thread(officeA);
		Thread b = new Thread(officeB);
>>>>>>> af5775a9fd8b6995bd33bbabbb50401764a45da2
		
		a.start();
		b.start();
	}		
}



