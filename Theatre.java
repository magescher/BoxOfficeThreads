package assignment6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to construct seating queue by highest priority and assign seats
 */
public class Theatre 
{
	private static final String[] ROWS = {"A","B","C","D","E","F","G","H","J","K","L",
			"M","N","P","Q","R","S","T","U","V","W","X","Y","Z", "AA"};
	public Queue<String> seats = new LinkedList<String>();
	private static final int CENTER_RIGHT = 114;  // One of two center most seats
	private static final int CENTER_LEFT = 115; 
	private static final int LEFT_MOST = 128;     // Left most seat in each row 
	private int firstRowOffset = 3;               // Seat offset for first row
	
	/**
	 * Constructs a Theater object  
	 */
	Theatre()
	{
	/*	Orders seats in array from most desirous to least desirous
	 *	Allocates from center most seats, moves outward in each direction */                   
		for(String s: ROWS)
		{
			seats.add(s + CENTER_LEFT); 
			seats.add(s + CENTER_RIGHT); 
			
			for (int i = 1; CENTER_LEFT + i <= LEFT_MOST - firstRowOffset; i ++) 
			{ 
				if(s.equals("AA") && i == 4) { i += 6; } // Skip Handicapped seats
				seats.add(s + (CENTER_LEFT + i)); 
				seats.add(s + (CENTER_RIGHT - i)); 
			}
			firstRowOffset = 0;                 // offset only applies for first row
		}
	}
	
	/**
	 * Finds the next best available seat in the theater. 
	 * Parameters are unnecessary for this configuration
	 * but kept to meet requirements
	 * @param t seat configuration
	 * @param customer next customer in line
	 * @return a string containing the best available seat; null if no seat is available 
	 */
	public String bestAvailableSeat(Theatre t, Integer customer) { return seats.peek(); }
	
	/**
	 * Determines if theater seats sold out
	 * @return a string containing the best available seat; null if no seat is available 
	 */
	public String isSoldOut() { return seats.peek(); }
	
	/**
	 * Marks the seat as taken (no longer available to sell).
	 * Parameter unused but kept to meet requirements
	 * @param seat the seat to be marked as taken 
	 */
	public void markAvailableSeatTaken(String seat) { seats.remove(); }

}
