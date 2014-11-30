package assignment6;

import java.util.Random;

public class A6Driver 

{
	/* TODO: are these variables declared correctly? should they be static? */
	public final static int LEAST_CUST = 100;
	public final static int MOST_CUST = 1000;
	
	public static void main(String[] args)
	{
		Theatre theatre = new Theatre();  
		System.out.println(theatre.seats);
		
		// TODO: is this done correctly? (Doing this correctly is worth 1 pt of overall project)
		// NOTE: Usually this should be a field rather than a method 
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

	    int randomA = rand.nextInt((MOST_CUST - LEAST_CUST) + 1) + LEAST_CUST;
	    int randomB = rand.nextInt((MOST_CUST - LEAST_CUST) + 1) + LEAST_CUST;
		
		Runnable officeA = new BoxOffice("Box Office A", randomA, theatre);
		Runnable officeB = new BoxOffice("Box Office B", randomB, theatre);
		
		Thread a = new Thread(officeA);
		Thread b = new Thread(officeB);
		
		a.start();
		b.start();
	}		
}



