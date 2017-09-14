package GraphAlgorithms;

import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 12.09.17.
 */
abstract class GraphAlgorithm {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    GraphAlgorithm(ArrayList<Vertex> vertices, ArrayList<Edge> edges){
        this.vertices = vertices;
        this.edges = edges;
        for(Vertex v : vertices){
            v.visited = false;
            v.colorID = 0;
        }
    }
}
