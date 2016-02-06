package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ksama on 2/6/16.
 */
public class ItineraryFinder {
  public List<String> findItinerary(String[][] tickets) {
    HashMap<String,ArrayList<String>>  pathMap = new HashMap<String, ArrayList<String>>();
    for(int i=0;i<tickets.length;i++){
      ArrayList<String> destinations = pathMap.get(tickets[i][0]);
      if(destinations == null){
        destinations = new ArrayList<String>();
        pathMap.put(tickets[i][0], destinations);
      }
      destinations.add(tickets[i][1]);
    }

    for(ArrayList<String> dests:pathMap.values())
    {
      Collections.sort(dests);
    }

    ArrayList<String> itinerary = new ArrayList<String>();
    String source = "JFK";
    itinerary.add(source);
    ArrayList<String> dests = pathMap.get(source);
    while(dests!=null && dests.size()>0){
       source = dests.remove(0);
       itinerary.add(source);
       dests = pathMap.get(source);
    }
     return itinerary;
  }
}
