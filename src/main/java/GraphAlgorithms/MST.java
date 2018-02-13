package GraphAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Andreas Wassum on 11.09.17.
 */


/**
 * A class structure for disjoint sets.
 */
class DisjointSets{

    private int[] sets;

    DisjointSets(int numb){
        sets = new int[numb+1];
        for(int i=1; i<=numb; i++)
            sets[i] = -1;
    }

    /**
     * Merging sets. The roots get a decreased number.
     * The lower the number, the more elements the set contains..
     * This reflects the height of the union tree
     *
     * @param a  the first set id
     * @param b  the second set id
     */
    void union(int a, int b){
        if(sets[b] < sets[a])
            sets[a] = b;
        else{
            if(sets[a] == sets[b])
                sets[a]--;
            sets[b] = a;
        }
    }


    /**
     * Find the set for a given number x.
     *
     * @param x an object represented by the number x
     * @return  the set id for x.
     */
    int findSet(int x){
        if(sets[x] < 0)
            return x;
        else
            return findSet(sets[x]);
    }
}


/**
 * class for finding a minimum spanning tree from a graph, given by its lists
 * of edges and vertices.
 * Based on Kruskal's algorithm.
 */
public class MST extends GraphAlgorithm {

    private PriorityQueue<Edge> edgeQ = new PriorityQueue<>();
    private DisjointSets djSet;


    /**
     * Find a minimum spanning tree of the given graph.
     * The edge at the front of the queue is polled from the queue.
     * If the two adjacent vertices are not stored in the same set,
     * store them in the same set by calling the union method.
     * This implies that the selected edge is a part of the MST.
     */
    private void findMST(){
        while(!edgeQ.isEmpty()){
            Edge currEdge = edgeQ.poll();
            Vertex from = currEdge.from;
            Vertex to = currEdge.to;
            int rootFrom = djSet.findSet( from.id );
            int rootTo = djSet.findSet( to.id );
            if(rootFrom != rootTo){
                djSet.union(rootFrom, rootTo);
            }
            else{
                currEdge.colorID = 0;
            }
        }
    }


    /**
     * Adding each edge to a priority queue, where the front of the
     * queue contains the edge with the lowest cost.
     *
     * @param vertices  list of vertices.
     * @param edges     list of edges.
     */
    public MST(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        super(vertices, edges);
        djSet = new DisjointSets(vertices.size());
        for(Edge e : edges){
            edgeQ.add(e);
        }
        findMST();
    }



}
