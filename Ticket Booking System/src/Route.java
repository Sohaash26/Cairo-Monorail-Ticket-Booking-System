import java.util.ArrayList;

public class Route {
	private String origin; // origin 
	private String destination; // destination
	public static int countRoutes = 0; // to count routes
	public ArrayList<Route> routes = new ArrayList<Route>(); // Collection of routes
	
	// Constructors
	public Route()
	{
		origin = null;
		destination = null;
		countRoutes++;
	}
	public Route(String origin , String destination)
	{
		countRoutes++;
		this.origin = origin;
		this.destination = destination;
	}
	
	// Setters , getters
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "[Origin=" + origin + ", Destination=" + destination + "]";
	}
	
	
}
