package assignment6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BoxOffice implements Runnable 
{
	private String officeName;
	private Queue<Integer> customers = new LinkedList<Integer>();
	private Theatre theatre; 
	public final static int LEAST_CUST = 100; // min number of customers in line 
	public final static int MOST_CUST = 1000; // max number of customers in line 

	BoxOffice(String name, Theatre t) 
	{ 
		officeName = name; 
		theatre = t;
		// Initialize queue of clients
		Random rand = new Random();
	    int numCust = rand.nextInt((MOST_CUST - LEAST_CUST) + 1) + LEAST_CUST;
	    for(int i = 0; i < numCust ; i ++) { customers.add(1); } 
	}
	
	@Override
	public void run() 
	{   // this function could be made shorter. written as is to match requirements
		System.out.println(officeName + " open. Initial customers in line: " + customers.size());
		while(theatre.isSoldOut() != null)
		{	
			synchronized(this)
			{
				String seat = theatre.bestAvailableSeat(theatre,customers.peek());  
				if(seat != null)
				{
					theatre.markAvailableSeatTaken(seat);     
					printTicketSeat(seat);
					customers.poll(); // Serve first customer in line and remove them from queue
					customers.add(1); // Add new customer each time one is served to ensure line is never empty
				}
				else { break; }       
			}
		}
	    System.out.println(officeName + "- The show is sold out. Please come back for future shows. Exiting...");
	}
	
	/*
	printTicketSeat(seat)  
	Input: seat is the location of an available seat in the theater.   
	output: A ticket for that seat is printed to the screen 
	– leave it on the screen long enough to be read easily by the client. 
	*/
	// TODO: add delay on display?
	public void printTicketSeat(String seat) { System.out.println(officeName + ": Reserved seat #" + seat);}
	
}
