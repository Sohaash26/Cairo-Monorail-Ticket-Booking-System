import java.util.ArrayList;
import java.util.Scanner;

// Passenger is a child to Person
// It inherits from it all attributes and methods
public class Passenger extends Person {
	
	// Every passenger from the collection has a name , id , age and account
	public ArrayList <Passenger> Passengers = new ArrayList<Passenger>(); // Collection of passengers
	public static int countPassengers = 0; // to count passengers
	public ArrayList <Ticket> Booked_Tickets = new ArrayList<Ticket>(); // Collection of tickets
	
	// Constructors
	public Passenger()
	{
		super(); // this will call the default constructor of Person if passenger is empty
	}
	
	public Passenger(String name , int age , int id , Account account)
	{
		super(name , age , id , account); // this will call the parameterized constructor of Person
	}
	
	
	
	// Methods
	public void viewInfo() // Overridden method from person
	{
		for(int i =0; i<Passengers.size();i++)
		{
			System.out.println("Name: " + Passengers.get(i).getName());
			System.out.println("Age: " + Passengers.get(i).getAge());
			System.out.println("ID: " + Passengers.get(i).getID());
			System.out.println("E-mail: " + Passengers.get(i).getAcc().getEmail());
			System.out.println("Password: " + Passengers.get(i).getAcc().getPassword());
		}
	}
	
	public void createAcc()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ID you want to create the account associated with it");
		int enteredID = input.nextInt();
		input.nextLine();
		for(int i =0; i<Passengers.size();i++)
		{	
			if(enteredID == Passengers.get(i).getID())
			{
				input = new Scanner(System.in);
				Account newAcc = new Account();
				System.out.println("Enter an un-registered email");
				String unregisteredEmail = input.nextLine();
				newAcc.setEmail(unregisteredEmail);
				System.out.println("Enter an un-registered password");
				String unregisteredPass = input.nextLine();
				newAcc.setPassword(unregisteredPass);
				Passengers.get(i).setAcc(newAcc);
				System.out.println("Displaying info..");
				viewInfo();
			}
			else
			{
				System.out.println("Can not create an account!");
			}
		}

	}

	public void manageAcc()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ID that is associated with the account you would like to manage it");
		int enteredID = input.nextInt();
		input.nextLine();
		for(int i =0; i<Passengers.size();i++)
		{
			if(enteredID == Passengers.get(i).getID())
			{
				// if the associated ID's account is null , tell user to create an account
				if(Passengers.get(i).getAcc().getEmail().equals(null) && Passengers.get(i).getAcc().getPassword().equals(null))
				{
					System.out.println("Create an account first!");
				}
				else
				{
	
				int updateChoice;
				do {
				System.out.println("What info would you like to update?");
				System.out.println("1) E-mail");
				System.out.println("2) Password");
				System.out.println("0) Exit");
				updateChoice = input.nextInt();
				input.nextLine();
				switch(updateChoice)
				{
				case 1:
					System.out.println("Enter new email");
					String newEmail = input.nextLine();
					Passengers.get(i).getAcc().setEmail(newEmail);
					System.out.println("Email updated sucessfully!");
					System.out.println("Displaying info..");
					viewInfo();
					break;
				case 2:
					System.out.println("Enter new password");
					String newPass = input.nextLine();
					Passengers.get(i).getAcc().setPassword(newPass);
					System.out.println("Password updated sucessfully!");
					System.out.println("Displaying info..");
					viewInfo();
					break;
				default:
					System.out.println("Enter a valid choice");
					break;
				}
			}while(updateChoice!=0);
		}
		}
			else
				System.out.println("Passenger not found!");
	}
	}	
	
	public boolean searchTrain() // search for a train depending on its route and id
	{
		Scanner input = new Scanner(System.in);
		Train train = new Train();
		System.out.println("Enter the origin and destination");
		String searchOrigin = input.nextLine();
		String searchDest = input.nextLine();
		for(int i =0; i<train.train_routes.size();i++)
		{
			if(train.train_routes.get(i).getOrigin().equals(searchOrigin) && train.train_routes.get(i).getDestination().equals(searchDest))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	public void bookTicket() // books a ticket by selecting route , time slot and seat number from AVAILABLE SEATS! , the passenger can book more than one seat 
	{
		
		Scanner input = new Scanner(System.in);
		Ticket newTicket;
		Train newTrain;
		Time newTimeSlot;
		int x;
		System.out.println("Enter your origin");
		String newOrigin = input.nextLine();
		System.out.println("Enter your destination");
		String newDest = input.nextLine();
		System.out.println("Choose a seat from the available ones");
		System.out.println("Choose one of the seats from these seats: ");
		Ticket.availableSeats();
		int newSeatNum = input.nextInt();
		System.out.println("Choose a time slot ");
		Time.Add_time_slots();
		System.out.println("Enter first hour");
		int firstHour = input.nextInt();
		System.out.println("Enter second hour");
		int secondHour = input.nextInt();
		newTimeSlot = new Time(firstHour , secondHour);
		
		System.out.println("");
		newTicket = new Ticket(newOrigin , newDest , newSeatNum , firstHour , secondHour);
		Booked_Tickets.add(newTicket);
		newTrain = new Train(newOrigin,newDest); // a train is created
		Admin.addTrain(newTrain); // add train
		System.out.println("Ticket has been booked!");	
		viewTickets();
		do
			{
		System.out.println("Would you like to reserve one more seat?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		x = input.nextInt();
		input.nextLine();
		switch(x)
		{
		case 1:
			System.out.println("Choose a seat from the available ones");
			Ticket.availableSeats();
			int reserveMoreSeat = input.nextInt();
			System.out.println("Choose a time slot ");
			Time.Add_time_slots();
			System.out.println("Enter first hour");
			int firstHourr = input.nextInt();
			System.out.println("Enter second hour");
			int secondHourr = input.nextInt();
			newTimeSlot = new Time(firstHourr , secondHourr);
			newTicket = new Ticket(newOrigin , newDest , reserveMoreSeat , firstHourr , secondHourr);
			Booked_Tickets.add(newTicket);
			newTrain = new Train(newOrigin,newDest);
			Admin.addTrain(newTrain);
			System.out.println("Ticket has been booked!");	
			viewTickets();
			break;
		case 2:
			break;
		}
			} while(x!=2);
		
	}
	
	
	public void cancelTicket() // cancels a ticket by selecting its id , removed from booked_tickets , when a ticket is removed , that seat is available
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the id that is associated with the ticket you would like to cancel");
		int t_id = in.nextInt();
		for(int i = 0; i<Booked_Tickets.size();i++)
		{
			if(t_id == Booked_Tickets.get(i).getID())
			{
				System.out.println(Booked_Tickets.get(i).getID() + " this ticket has been sucessfully removed!" );
				//Booked_Tickets.get(i).availableSeats()
				Booked_Tickets.remove(i);
			}
			else
			{
				System.out.println("Ticket not found!");
			}
		}
	}
	
	public void updateTicket() // updates a ticket by searching for its id , when cancel a ticket we call "cancelTicket()" / to book we call "bookTicket()"
	{
		Scanner input = new Scanner(System.in);
		int updateTicket;
		System.out.println("Enter the id that is associated with the ticket");
		int aID = input.nextInt();
		
		for(int i =0; i<Booked_Tickets.size();i++)
		{
			if(aID == Booked_Tickets.get(i).getID())
			{
				do
				{
				System.out.println("What would you like to update?");
				System.out.println("1) Origin");
				System.out.println("2) Destination");
				System.out.println("3) Cancel");
				System.out.println("4) Book another ticket");
				System.out.println("0) Exit");
				updateTicket = input.nextInt();
				input.nextLine();
				switch(updateTicket)
				{
				case 1:
					System.out.println("Enter origin");
					String updatedOrigin = input.nextLine();
					Booked_Tickets.get(i).route.setOrigin(updatedOrigin);
					System.out.println("Done");
					break;
				case 2:
					System.out.println("Enter origin");
					String updatedDest = input.nextLine();
					Booked_Tickets.get(i).route.setDestination(updatedDest);
					System.out.println("Done");
					System.out.println("Your new origin is now from " + Booked_Tickets.get(i).route.getOrigin() + " to " + Booked_Tickets.get(i).route.getDestination());
					break;
				case 3:
					cancelTicket();
					break;
				case 4:
					bookTicket();
					break;
				}
			}while(updateTicket!=0);
		}
			else
			System.out.println("Ticket not found!");
		}
	}
	
	public void viewTickets() // displays the passenger HIS TICKETS
 	{
		
		for(int i =0; i<Booked_Tickets.size();i++)
		{
			
			System.out.println("Ticket #" + Booked_Tickets.indexOf(Booked_Tickets.get(i))+1);
			System.out.println("ID: " + Booked_Tickets.get(i).getID());
			System.out.print("Time slot: ");
			Booked_Tickets.get(i).time_slot.viewTimeSlot();
			
			System.out.println("Seat number: " + Booked_Tickets.get(i).getSeatNumber());
			System.out.println("Route: " + Booked_Tickets.get(i).route);
			System.out.println("Train ID: " + Admin.trains.get(i).getId());
			System.out.println(" ");
			
		}
		
	}
	
	// Override abstract methods from Person
	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void setAcc(Account account) {
		// TODO Auto-generated method stub
		this.account = account;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public Account getAcc() {
		// TODO Auto-generated method stub
		return account;
	}
}


