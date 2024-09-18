import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Admin extends Person{
	public ArrayList <Admin> admins = new ArrayList<>(); // Collection of admins
	public static int countAdmins = 0; // to count admins
	public static ArrayList <Train> trains = new ArrayList<Train>(); // Collection of trains
	public ArrayList <Ticket> tickets = new ArrayList<>(); // Collection of tickets
	
	public Admin()
	{
		super();
	}
	public Admin(String name , int age , int id , Account account)
	{
		super(name , age , id , account); // this will call the parameterized constructor of Person
	}
	
	public void createAcc()
	{
            
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ID you want to create the account associated with it");
		int enteredID = input.nextInt();
		input.nextLine();
		for(int i =0; i<admins.size();i++)
		{	
                    try{
			if(enteredID == admins.get(i).getID())
			{       
                                Formatter file = new Formatter("/Users/youssef/Desktop/javaproj/accounts.txt");
                                
				input = new Scanner(System.in);
				Account newAcc = new Account();
				System.out.println("Enter an un-registered email");
				String unregisteredEmail = input.nextLine();
				newAcc.setEmail(unregisteredEmail);
				System.out.println("Enter an un-registered password");
				String unregisteredPass = input.nextLine();
				newAcc.setPassword(unregisteredPass);
				admins.get(i).setAcc(newAcc);
                                file.format("Email: %s\n" + "Password: %s" , admins.get(i).getAcc().getEmail() , admins.get(i).getAcc().getPassword());
                                file.close();
				System.out.println("Displaying info..");
				viewInfo();
			}
			else
			{
				System.out.println("Can not create an account!");
			}
                    }catch(FileNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }
		}

	}
	
	public void manageAccount()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id associated with the admin");
		int adminID = input.nextInt();
		for(int i =0; i<admins.size();i++)
		{
			if(adminID == admins.get(i).getID())
			{
				do {
				System.out.println("What would you like to update for this admin?");
				System.out.println("1)Email");
				System.out.println("2)Password");
				System.out.println("0) Exit");
				int choice = input.nextInt();
				input.nextLine();
				switch(choice)
				{
				case 1:
					System.out.println("Enter an email");
					String newAdminEmail = input.nextLine();
					admins.get(i).getAcc().setEmail(newAdminEmail);
					System.out.println("Displaying info..");
					viewInfo();
					break;
				case 2:
					System.out.println("Enter an password");
					String newAdminPass = input.nextLine();
					admins.get(i).getAcc().setPassword(newAdminPass);
					System.out.println("Displaying info..");
					viewInfo();
					break;
				}
				}while(adminID!=0);
			}
			else
				System.out.println("Admin not found!");
		}
	}
	
	
	public static void addTrain(Train t)
	{
		trains.add(t); // add train into the collection
	}
	
	public boolean searchAdmin(int id)
	{
		for(int i =0; i<admins.size();i++)
		{
			if(id == admins.get(i).getID())
			{
				return true;
			}
		}
		return false;
	}
	
	public void removeTrain()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id that is associated with the train");
		int trainID = input.nextInt();
		input.nextLine();
		for(int i =0; i<trains.size();i++)
		{
			if(trainID == trains.get(i).getId())
			{
				System.out.println("Train removed sucessfully!");
				trains.remove(i);
			}
			else
				System.out.println("Train not found!");
		}
	}
	
	public void updateTrain()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id that is associated with the train");
		int trainID = input.nextInt();
		input.nextLine();
		int updateTrainChoice;
		for(Train t : trains)
		{
			if(trainID == t.getId())
			{
				do {
				System.out.println("What info would you like to change?");
				System.out.println("1) ID");
				System.out.println("2) Route");
				System.out.println("0) Exit");
				updateTrainChoice = input.nextInt();
				input.nextLine();
				switch(updateTrainChoice)
				{
				case 1:
					System.out.println("Enter new ID for this train");
					int newTrainID = input.nextInt();
					t.setId(newTrainID);
					System.out.println("Done!");
					System.out.println("It's new ID is " + t.getId());
					break;
				case 2:
					System.out.println("Enter new origin");
					String newRouteOrigin = input.nextLine();
					System.out.println("Enter new destination");
					String newRouteDest = input.nextLine();
					Route newTrainRoute = new Route(newRouteOrigin , newRouteDest);
					t.train_routes.add(newTrainRoute);
					System.out.println("Done!");
					System.out.println("New route of this train is " + t.train_routes);
				}
				}while(updateTrainChoice!=0);
			}
			else
				System.out.println("Train not found!");
		}
	}
	
	public void manageAcc()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ID that is associated with the account you would like to manage it");
		int enteredID = input.nextInt();
		input.nextLine();
		for(int i =0; i<admins.size();i++)
		{
			if(enteredID == admins.get(i).getID())
			{
				// if the associated ID's account is null , tell user to create an account
				if(admins.get(i).getAcc().getEmail() == null && admins.get(i).getAcc().getPassword() == null)
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
				updateChoice = input.nextInt();
				input.nextLine();
				switch(updateChoice)
				{
				case 1:
					System.out.println("Enter new email");
					String newEmail = input.nextLine();
					admins.get(i).getAcc().setEmail(newEmail);
					System.out.println("Email updated sucessfully!");
					break;
				case 2:
					System.out.println("Enter new password");
					String newPass = input.nextLine();
					admins.get(i).getAcc().setPassword(newPass);
					System.out.println("Password updated sucessfully!");
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
	
	public void viewTrains()
	{
		for(Train t : trains)
		{
			System.out.println("Train # " + trains.indexOf(t)+1);
			System.out.println("ID: " + t.getId());
			System.out.println("Route: " + t.train_routes);
		}
	}
	public void generateReport(Passenger p) 
	{
	
		Scanner input = new Scanner(System.in);
                
		System.out.println("Enter a certain origin to search");
		String sOrig = input.nextLine();
		System.out.println("Enter a certain destination to search");
		String sDest = input.nextLine();
		for(int j =0; j<p.Booked_Tickets.size();j++)
		{
			if(p.Booked_Tickets.get(j).route.getOrigin().equals(sOrig) && p.Booked_Tickets.get(j).route.getDestination().equals(sDest))
			{
				System.out.println("Found!");
				System.out.println("It's total fare is : " + p.Booked_Tickets.get(j).getTotalFare());
				System.out.println("Total number of bookings are " + Ticket.getCountTickets());
                                ;
               
			}
			else
			{
				System.out.println("Not found!");
			}
		}	
	}
	
	
        public void createReportFile(Passenger p) throws FileNotFoundException
        {
            Formatter x = new Formatter("Report.txt");
            for(Ticket y : p.Booked_Tickets)
            {
                x.format("Total fare: %s\n" + "Number of tickets: %s" , String.valueOf(y.getTotalFare()) , String.valueOf(Ticket.getCountTickets()));
                System.out.println("File created!");
                x.close();
                
            }
            
        }
        
	@Override
	public void viewInfo() {
		// TODO Auto-generated method stub
		for(int i =0; i<admins.size();i++)
		{
			System.out.println("Name: " + admins.get(i).getName());
			System.out.println("Age: " + admins.get(i).getAge());
			System.out.println("ID: " + admins.get(i).getID());
			System.out.println("E-mail: " + admins.get(i).getAcc().getEmail());
			System.out.println("Password: " + admins.get(i).getAcc().getPassword());
		}
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
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
