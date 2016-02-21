package graphs;

import java.util.Collection;

/**
 * Created by ksama on 2/18/2016.
 */
public class NoOfTriangles {
    public int countNoOfTriangles(Graph<Integer> graph){
        Collection<Vertex<Integer>> vertices =  graph.getAllVertex();
        for(Vertex v:vertices){

        }

        return 0;
    }
    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        NoOfTriangles not = new NoOfTriangles();
    }
}
