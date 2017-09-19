package GraphAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Andreas Wassum on 11.09.17.
 */


/**
 * A class structure for disjoint sets.
 * Used to calculate a minimum spanning tree.
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
     * This reflects the height of the union tree */
    void union(int a, int b){
        // If a is deeper than b, join b to the set of a
        if(sets[b] < sets[a])
            sets[a] = b;
        else{
            //If equal, choose a as root
            if(sets[a] == sets[b])
                sets[a]--;
            sets[b] = a;
        }
    }


    /**
     *  Find the set for a given number x.
     */
    int findSet(int x){
        // If the number is less than zero, return its number
        if(sets[x] < 0)
            return x;
            // Else return set number of its root
        else
            return findSet(sets[x]);
    }
}


/**
 * class for finding a minimum spanning tree from a graph, given by its lists
 * of edges and vertices.
 */
public class MST extends GraphAlgorithm {

    private PriorityQueue<Edge> edgeQ = new PriorityQueue<>();
    private DisjointSets djSet;


    /**
     * Find a minimum spanning tree of the given graph.
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
     *
     * @param vertices
     * @param edges
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
