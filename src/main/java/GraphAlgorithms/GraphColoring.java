package GraphAlgorithms;

import java.util.ArrayList;

/**
 * Assigning color to each vertex. Adjacent vertices can
 * not be assigned identical colors.
 *
 * Created by andreas on 13.09.17.
 */
public class GraphColoring extends GraphAlgorithm {


    /**
     * Assign a color to a given vertex 'curr'.
     * Visit all adjacent vertices of 'curr', and mark their
     * color as occupied.
     * Then iterate over all colors, and assign
     * 'curr' the first non-occupied color.
     *
     * @param curr  The vertex to be assigned a color.
     */
    private void assignColor(Vertex curr){
        boolean[] adjColor = new boolean[8];
        for(Edge adj : curr.edges){
            Vertex adjV;
            if(adj.to == curr)
                adjV = adj.from;
            else
                adjV = adj.to;
            adjColor[ adjV.colorID ] = true;
        }
        for(int i=2; i<=7; i++){
            if(!adjColor[i]){
                curr.colorID = i;
                break;
            }
        }
    }


    /**
     * Assigns a color to each vertex
     *
     * @param vertices  list of vertices
     * @param edges     list of edges
     */
    public GraphColoring(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        super(vertices, edges);
        for(Vertex v : vertices){
            assignColor(v);
        }
    }
}
