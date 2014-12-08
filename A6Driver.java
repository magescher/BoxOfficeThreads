package assignment6;

public class A6Driver 

{
	public static void main(String[] args)
	{
		Theatre theatre = new Theatre();  
		
		Runnable officeA = new BoxOffice("Box Office A", theatre);
		Runnable officeB = new BoxOffice("Box Office B", theatre);
		
		Thread a = new Thread(officeA);
		Thread b = new Thread(officeB);
		
		a.start();
		b.start();
	}		
}



