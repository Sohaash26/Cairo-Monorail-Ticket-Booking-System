
public class Account {
    private String email;
	private String password;
	
	// Constructors
	// When an object from account is created
	// this object's address is stored in "this"
	public Account(String email , String password)
	{
		this.email = email;
		this.password = password;
	}
	public Account()
	{
		email = null;
		password = null;
	}
	public Account(Account acc)
	{
		acc.email = email;
		acc.password = password;
	}
	
	// Setters , Getter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Account [email=" + email + ", password=" + password + "]";
	}	
	
	
}

