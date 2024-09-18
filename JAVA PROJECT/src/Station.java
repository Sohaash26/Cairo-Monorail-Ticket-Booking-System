import java.util.ArrayList;

public class Station {
    public ArrayList <Route> Station_routes = new ArrayList<Route>();
    
    
    public Station()
    {
        for(Route x : Station_routes)
        {
            x = new Route();
        }
    }
    
    public Station(String origin , String destination)
    {
        Route r = new Route(origin , destination);
        Station_routes.add(r);
    }
}
