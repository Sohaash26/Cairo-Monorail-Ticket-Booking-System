

// Parent class for admin and passenger
public abstract class Person {
	protected String name;
	protected int age;
	protected int id;
	public Account account;
	
	// Constructors
	public Person()
	{
		name = null;
		age = 0;
		id = 0;
		account = new Account(); // this will call the default constructor of Account
	}
	public Person(String name , int age , int id , Account acc)
	{
		this.name = name;
		this.age = age;
		this.id = id;
		account = new Account(acc);
	}
	
	// Abstract methods
	public abstract void viewInfo();
	public abstract void setName(String name);
	public abstract void setAge(int age);
	public abstract void setID(int id);
	public abstract void setAcc(Account account);
	public abstract int getID();
	public abstract String getName();
	public abstract int getAge();
	public abstract Account getAcc();
	
	
}
