package GraphAlgorithms;
/**
 * An Edge object represents an edge in the GUI
 *
 * Created by Andreas Wassum on 10.09.17.
 */
public class Edge implements Comparable<Edge> {
    public int colorID = 1, cost = 1;
    public Vertex from,to;

    public Edge(Vertex from, Vertex to){
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}
