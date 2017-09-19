package GraphAlgorithms;

import java.util.ArrayList;

/**
 * Created by andreas on 13.09.17.
 */
public class GraphColoring extends GraphAlgorithm {


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



    public GraphColoring(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        super(vertices, edges);
        for(Vertex v : vertices){
            assignColor(v);
        }
    }
}
