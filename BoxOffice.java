package assignment6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Class to run box office logic and print tickets
 */
public class BoxOffice implements Runnable 
{
	private String officeName;
	private Queue<Integer> customers = new LinkedList<Integer>(); 	//the line of customers 
	private Theatre theatre; 
	public final static int LEAST_CUST = 100; // min number of customers in line 
	public final static int MOST_CUST = 1000; // max number of customers in line 
	
	/**
	 * Constructs a BoxOffice object
	 * @param name the name of the box office 
	 * @param t the theater it is associated with 
	 */
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
	/**
	 * Sells the best available ticket to the next person in line. 
	 * Overrides the run() method in the Runnable Interface 
	 */
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
	
	/**
	 * Prints a given ticket to the screen 
	 * @param seat the ticket to be printed 
	 */
	public void printTicketSeat(String seat) { System.out.println(officeName + ": Reserved seat #" + seat);}
	
}
