package GraphAlgorithms;
/**
 * Created by Andreas Wassum on 10.09.17.
 */
public class Edge {
    int colorID = 0;
    public Vertex from,to;

    public Edge(Vertex from, Vertex to){
        this.from = from;
        this.to = to;
    }

}