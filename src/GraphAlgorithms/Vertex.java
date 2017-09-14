package GraphAlgorithms;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


/**
 * Created by Andreas Wassum on 8/30/17.
 */
public class Vertex {
    public int x,y, colorID = 0;
    public boolean marked, visited;
    public Ellipse2D.Double ellipse;
    public ArrayList<Edge> edges = new ArrayList<>();

    public Vertex(int x, int y){        this.x = x;
        this.y = y;
    }
}
