package GraphAlgorithms;

import java.util.ArrayList;

/**
 * A class for finding all the connected components in a graph
 *
 * Created by Andreas Wassum on 11.09.17.
 */
public class ConnectedComponents extends GraphAlgorithm {

    private int group = 2;


    /**
     * Iterates over all edges, and call dfs on any vertex not already visited.
     * The number of dfs calls equals the number of components
     *
     * @param vertices  list of vertices
     * @param edges     list of edges
     */
    public ConnectedComponents(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        super(vertices, edges);
        for(Vertex v : vertices){
            if(!v.visited){
                dfs(v);
                group++;
            }
        }
    }

    /**
     * Performing a depth-first search to find the connected components
     *
     * @param current  current node in the DFS
     */
    private void dfs(Vertex current){
        current.visited = true;
        current.colorID = group;
        for(Edge edge : current.edges){
            Vertex towards;
            if(edge.from != current) {
                towards = edge.from;
            }
            else{
                towards = edge.to;
            }
            if(!towards.visited){
                dfs(towards);
            }
        }
    }
}
