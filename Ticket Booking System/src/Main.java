import java.util.Scanner;

public class Main {
	
	static void welcomeSystem()
	{
		System.out.println("Welcome to cairo monorail ticket booking system!");
		System.out.println("---------------------------------------------------");
		
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		Passenger p = new Passenger();
		Admin a = new Admin();
		
		do
		{
		System.out.println("1) Passenger");
		System.out.println("2) Admin");
		System.out.println("0) Exit.");
		choice = in.nextInt();
		in.nextLine();
		switch(choice)
		{
		case 1:
			int passengerChoice = 0;
			do {
			System.out.println("As a passenger.");
			System.out.println("1) Enter your information");
			System.out.println("2) Create Account");
			System.out.println("3) Edit information");
			System.out.println("4) Book a ticket");
			System.out.println("5) Have access to tickets");
			System.out.println("6) Update a booked ticket");
			System.out.println("7) Remove a booked ticket");
			System.out.println("0) Exit.");
			passengerChoice = in.nextInt();
			in.nextLine();
			if(passengerChoice == 1)
			{
				System.out.println("Enter your name ");
				String namePassenger = in.nextLine();
				System.out.println("Enter your age");
				int agePassenger = in.nextInt();
				System.out.println("Enter your ID");
				int pID = in.nextInt();
				p.setName(namePassenger);
				p.setAge(agePassenger);
				p.setID(pID);
				p.Passengers.add(p);
				System.out.println("Displaying your information..");
				p.viewInfo();
			}
			if(passengerChoice == 2) 
			{
				p.createAcc();
			}
			if(passengerChoice == 3)
			{
				p.manageAcc();
			}
			if(passengerChoice == 4)
			{
				p.bookTicket();
			}
			if(passengerChoice == 5)
			{
				p.viewTickets();
			}
			if(passengerChoice == 6)
			{
				p.updateTicket();
			}
			if(passengerChoice == 7)
			{
				p.cancelTicket();
			}
			}
			while(passengerChoice!=0);
			break;
		
		case 2:
			int adminChoice = 0;
			do
			{
			System.out.println("As an admin.");
			System.out.println("1) Log in");
			System.out.println("2) Create Account");
			System.out.println("3) Edit information");
			System.out.println("4) Remove a train");
			System.out.println("5) View trains");
			System.out.println("6) Generate report");
			System.out.println("0) Exit");
			adminChoice = in.nextInt();
			in.nextLine();
			if(adminChoice == 1)
			{
				System.out.println("Enter your name");
				String aName = in.nextLine();
				System.out.println("Enter your email");
				String emailInput = in.nextLine();
				System.out.println("Enter your password");
				String passInput = in.nextLine();
				System.out.println("Enter your ID");
				int aID = in.nextInt();
				Account acc = new Account(emailInput , passInput);
				a.setName(aName);
				a.setAcc(acc);
				a.setID(aID);
				a.admins.add(a); // add admin into collection
				a.viewInfo();
			}
			if(adminChoice == 2)
			{
				a.createAcc();
			}
			if(adminChoice == 3)
			{
				a.manageAcc();
			}
			if(adminChoice == 4)
			{
				a.removeTrain();
			}
			if(adminChoice == 5)
			{
				a.viewTrains();
			}
			if(adminChoice == 6)
			{
				a.generateReport(p);
			}
			}
			while(adminChoice!=0);
		break;
		
		case 0:
			System.out.println("Goodbye!");
			System.exit(0);
		break;
			
		default:
			System.out.println("Enter a valid choice!");
		break;
		}

	}
		while(choice!=0);
	}

	
	public static void main(String args[])
	{
		welcomeSystem();
		
	
	}
}

