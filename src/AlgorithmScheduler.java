import GraphAlgorithms.*;
import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 11.09.17.
 */
public class AlgorithmScheduler {


    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public AlgorithmScheduler(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void decideAlgorithm(String operation){
        System.out.println("ALGO IS "+operation);
        switch (operation){
            case  "Connected Components":
                new ConnectedComponents(vertices, edges);
                break;
            case "Minimum Spanning Tree":
                new MST(vertices,edges);
                break;
            case "4 Coloring":
                new GraphColoring(vertices, edges);
                break;
            default:
                System.out.println("Error. No matching operation found! op is "+operation);
        }

    }
}
