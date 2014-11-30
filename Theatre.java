package assignment6;

import java.util.ArrayList;

public class Theatre 
{
	private final String[] ROWS = {"A","B","C","D","E","F","G","H","I","J","K","L",
			"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public ArrayList<String> seats = new ArrayList<String>();
	private ArrayList<StringBuffer> availability = new ArrayList<StringBuffer>();
	private final StringBuffer AVAILABLE = new StringBuffer("available");
	private final StringBuffer TAKEN = new StringBuffer("taken");
	private final int CENTER_RIGHT = 114;  // One of two center most seats
	private final int CENTER_LEFT = 115; 
	private final int LEFT_MOST = 128;     // Left most seat in each row 
	private int offset = 3;                // Seat offset for first row
	
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
	
	public boolean isSoldOut()
	{
		if (availability.contains(AVAILABLE)) { return false; }
		else { return true; }
	}
	
	/*
	bestAvailableSeat( )  
	Inputs: theater configuration, next client in line  
	Return value: best-available seat in the theater; or   
				 –1 if no seat is available. 
	*/
	public String bestAvailableSeat(/* TODO: taylor these inputs to match requirements */)
	{
		if(isSoldOut()) { return "-1"; }
		int index = availability.indexOf(AVAILABLE);
		return seats.get(index); // Returns best available seat
	}
	
	/*
	markAvailableSeatTaken(seat)  
	Input: seat is the place of an available seat in the theater.    
	output: The place of the seat is marked as taken. 
	*/
	public void markAvailableSeatTaken(String seat)
	{
		int i = seats.indexOf(seat);
		availability.set(i, TAKEN);
	}

}
