import java.util.ArrayList;
import java.util.Random;

public class Train {
	private int id;
	public ArrayList <Route> train_routes = new ArrayList<Route>();
	public static int countTrains = 0;
	public int seats = 500;
	public int idTrainLimit = 1524;
	
	public Train()
	{
		id = 0;
		for(Route r : train_routes)
		{
			r.setOrigin(null);
			r.setDestination(null);
		}
		countTrains++;
	}
	
	public Train(String tOrigin , String tDestination)
	{
		seats--;
		Random t_id = new Random();
		id = t_id.nextInt(idTrainLimit);
		Route newtRoute = new Route(tOrigin , tDestination);
		train_routes.add(newtRoute);
		countTrains++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCountTrains() {
		return countTrains;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
}
