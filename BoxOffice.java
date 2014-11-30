package assignment6;

public class BoxOffice implements Runnable 
{
	private String officeName;
	private static final int DELAY = 1000;
	private int numCust;
	private Theatre theatre; 

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
	
	/*
	printTicketSeat(seat)  
	Input: seat is the location of an available seat in the theater.   
	output: A ticket for that seat is printed to the screen 
	– leave it on the screen long enough to be read easily by the client. 
	*/
	// TODO: add delay on display?
	public void printTicketSeat(String seat) { System.out.println(officeName + ": Reserved seat #" + seat);}
	
}
