import GraphAlgorithms.*;
import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 11.09.17.
 */
public class AlgorithmScheduler {


    ArrayList<Vertex> vertices; ArrayList<Edge> edges;

    public AlgorithmScheduler(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void decideAlgorithm(String operation){
        System.out.println("ALGO IS "+operation);
        switch (operation){
            case  "Find Connected Components":
                new ConnectedComponents().solve(vertices, edges);
            case "Minimum Spanning Tree":
                new MST().solve(vertices,edges);
            default:
                System.out.println("Error. No matching operation found!");
        }

    }
}
