package assignment6;

public class BoxOffice implements Runnable 
{
	private String officeName;
	private static final int DELAY = 1000;
	private int numCust;
	private Theatre theatre; 
	
	/**
	 * Constructs a BoxOffice object 
	 * @param name the name of the office 
	 * @param num the number of customers in line 
	 * @param t	the theater for which the BoxOffice is selling tickets for
	 */
	BoxOffice(String name, int num, Theatre t) 
	{ 
		officeName = name; 
		numCust = num;
		theatre = t;
	}
	
	@Override
	public void run() 
	{
		System.out.println("Running " +  officeName );
		System.out.println(officeName + " : " + numCust + " customers");
		try 
		{
			while(numCust != 0) 
			{
				synchronized(this)
				{
					String seat = theatre.bestAvailableSeat();  
					if (!seat.equals("-1")) 
					{   // Seat Available 
						theatre.markAvailableSeatTaken(seat);     
						printTicketSeat(seat);
						numCust --;
					}    
					else 
					{ 	// Sold out 
						System.out.println(officeName + "- Sorry, we just sold out!"); 
						Thread.sleep(DELAY);
						break; 
					}
				}
			}
		// TODO: Will this ever happen?	
	     } catch (InterruptedException e) { System.out.println(officeName + " interrupted.");}
		
	     System.out.println(officeName + "- All customers have been served or the show is sold out. Exiting...");
	}
	
	// TODO: add delay on display?
	/**
	 * Prints the ticket to the screen 
	 * @param seat the seat to be printed 
	 */
	public void printTicketSeat(String seat) { System.out.println(officeName + ": Reserved seat #" + seat);}
	
}
