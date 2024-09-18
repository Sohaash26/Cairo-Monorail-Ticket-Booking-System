import java.util.Random;

public class Ticket {
	
	public static final double price = 5.5;
	public double ticketFare = 2.4;
	private int id;
	public double totalTicketFare = 0.0;
	private static int seatNumber = 0;
	public static int availableSeats = 20; // array of available seats
	public static int countTickets = 0; // to count tickets4
	public Route route; // each ticket has a route
	public Time time_slot; // each ticket has a time slot
	public static int IDLimit = 4932;
	
	public Ticket(String ori , String dest , int seatNum , int t1 , int t2)
	{	
		Random r = new Random();
		id = r.nextInt(IDLimit);
		route = new Route(ori , dest); 
		seatNumber = seatNum;
		countTickets++;
		time_slot = new Time(t1 , t2);
		time_slot.time_slots.add(time_slot);
		totalTicketFare = ticketFare * price;
	}
	public Ticket()
	{
		id = 0;
		seatNumber = 0;
		countTickets++;
	
	}
	
	// Setters , getters
	public int getID()
	{
		return id;
	}
	public int getSeatNumber()
	{
		return seatNumber;
	}
	public void addSeatNumber()
	{
		availableSeats++;
	}
	//public Time getTime()
	//{
		//return time;
	//}
	public double getTotalFare()
	{
		return totalTicketFare;
	}
	public static int getCountTickets()
	{
		return countTickets;
	}
	
	public static void availableSeats()
	{
		for(int i = 1; i<=availableSeats; i++)
		{
			System.out.println("Available: " + i);
			if(availableSeats == seatNumber)
			{
				System.out.println("Seat number " + seatNumber + " has been booked");
				break;
			}
		
		}
	}
	
	
}
