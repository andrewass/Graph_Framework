import GraphAlgorithms.*;
import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 11.09.17.
 */
public class AlgorithmScheduler {


    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;


    /**
     * The algorithm stores the same set of edges found in GUI.

     * @param vertices  the list of vertices added by the user in the GUI.
     * @param edges     the list of edges added by the user in the GUI.
     */
    public AlgorithmScheduler(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }


    /**
     * Based on input string, the matching algorithm is carried out.
     *
     * @param operation  contains the name of the algorithm to apply.
     */
    public void decideAlgorithm(String operation){
        System.out.println("ALGO IS "+operation);
        switch (operation){
            case  "Connected Components":
                new ConnectedComponents(vertices, edges);
                break;
            case "Minimum Spanning Tree":
                new MST(vertices,edges);
                break;
            case "Graph Coloring":
                new GraphColoring(vertices, edges);
                break;
            default:
                System.out.println("Error. No matching operation found! op is "+operation);
        }

    }
}
