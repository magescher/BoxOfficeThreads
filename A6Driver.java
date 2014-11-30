package assignment6;

import java.util.Random;

public class A6Driver 

{
	/* TODO: are these variables declared correctly? should they be static? */
	public static int leastCust = 100;
	public static int mostCust = 1000;
	
	public static void main(String[] args)
	{
		Theatre theatre = new Theatre();  
		System.out.println(theatre.seats);
		
		// TODO: is this done correctly? (Doing this correctly is worth 1 pt of overall project)
		// NOTE: Usually this should be a field rather than a method 
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

	    int randomA = rand.nextInt((mostCust - leastCust) + 1) + leastCust;
	    int randomB = rand.nextInt((mostCust - leastCust) + 1) + leastCust;
		
		Runnable officeA = new BoxOffice("Box Office A", randomA, theatre);
		Runnable officeB = new BoxOffice("Box Office B", randomB, theatre);
		
		Thread a = new Thread(officeA);
		Thread b = new Thread(officeB);
		
		a.start();
		b.start();
	}		
}



