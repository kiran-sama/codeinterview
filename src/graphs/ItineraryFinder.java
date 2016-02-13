package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ksama on 2/6/16.
 */
public class ItineraryFinder {
  public List<String> findItinerary(String[][] tickets) {
    HashMap<String,PriorityQueue<String>>  pathMap = new HashMap<String, PriorityQueue<String>>();
    for(int i=0;i<tickets.length;i++){
      PriorityQueue<String> destinations = pathMap.get(tickets[i][0]);
      if(destinations == null){
        destinations = new PriorityQueue<String>();
        pathMap.put(tickets[i][0], destinations);
      }
      destinations.add(tickets[i][1]);
    }

    ArrayList<String> itinerary = new ArrayList<String>();
    String source = "JFK";
    itinerary.add(source);
    PriorityQueue<String> dests = pathMap.get(source);
    while(dests!=null && dests.size()>0){
       source = dests.poll();
       itinerary.add(source);
       dests = pathMap.get(source);
    }
     return itinerary;
  }
}
