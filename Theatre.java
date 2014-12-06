package assignment6;

import java.util.ArrayList;

public class Theatre 
{
	private static final String[] ROWS = {"A","B","C","D","E","F","G","H","J","K","L",
			"M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public ArrayList<String> seats = new ArrayList<String>();
	private ArrayList<StringBuffer> availability = new ArrayList<StringBuffer>();
	private static final StringBuffer AVAILABLE = new StringBuffer("available");
	private static final StringBuffer TAKEN = new StringBuffer("taken");
	private static final int CENTER_RIGHT = 114;  // One of two center most seats
	private static final int CENTER_LEFT = 115; 
	private static final int LEFT_MOST = 128;     // Left most seat in each row 
	private int offset = 3;                // Seat offset for first row
	
	/**
	 * Constructs a Theater object  
	 */
	Theatre()
	{
	/*	Orders seats in array from most desirous to least desirous
	 *	Allocates from center most seats, moves outward in each direction */                   
		for(String s: ROWS)
		{
			seats.add(s + CENTER_LEFT); // Center most seat in each row
			seats.add(s + CENTER_RIGHT);
			for (int i = 1; CENTER_LEFT + i <= LEFT_MOST - offset; i ++) 
			{ 
				seats.add(s + (CENTER_LEFT + i)); 
				seats.add(s + (CENTER_RIGHT - i)); 
			}
			offset = 0;                 // offset only applies for first row
		}
		// Populate availability array to correspond to seat array (loose linked-list)
		for(int i = 0; i < seats.size(); i ++) { availability.add(AVAILABLE); }
	}
	
	/**
	 * Method checks if there are still seats available in the theater or 
	 * if it has been sold out. 
	 * @return true, if theater is sold out; false, it there are seats available 
	 */
	public boolean isSoldOut()
	{
		if (availability.contains(AVAILABLE)) { return false; }
		else { return true; }
	}
	
	
	/**
	 * Finds the next best available seat in the theater 
	 * @return the index of the available seat; -1 if no seat is available 
	 */
	public String bestAvailableSeat(/* TODO: taylor these inputs to match requirements */)
	{
		if(isSoldOut()) { return "-1"; }
		int index = availability.indexOf(AVAILABLE);
		return seats.get(index); // Returns best available seat
	}
	
	/**
	 * Marks the seat as taken (no longer available to sell) 
	 * @param seat, the seat to be marked as taken 
	 */
	public void markAvailableSeatTaken(String seat)
	{
		int i = seats.indexOf(seat);
		availability.set(i, TAKEN);
	}

}
