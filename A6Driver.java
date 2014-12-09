/**
 * @author Abigail Johnson
 * @author Carlos Rios
 * TA: Xander Morgan
 * Wednesday 4:30 pm 
 */

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
	
		Thread a = new Thread(new BoxOffice("Box Office A", theatre));
		Thread b = new Thread(new BoxOffice("Box Office B", theatre));
		
		a.start();
		b.start();
	}		
}



