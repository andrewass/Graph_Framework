import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import GraphAlgorithms.Edge;
import GraphAlgorithms.Vertex;

/**
 * Created by Andreas Wassum on 8/30/17.
 */
public class PaintPanel extends JPanel {

    private ArrayList<Vertex> vertices = new ArrayList();
    private ArrayList<Edge> edges = new ArrayList<>();
    private Vertex[] marked = new Vertex[2];
    private GraphGUI parentGUI;
    private int markedVertices = 0;

    /**
     *
     */
    PaintPanel(GraphGUI root){
        parentGUI = root;
        root.vertices = vertices;
        root.edges = edges;
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(root.addEdge.isSelected()) {
                   markVertex(e.getX(), e.getY());
                }
                else if(root.addVertex.isSelected()){
                    addVertex(e.getX(), e.getY());
                }
                repaint();
            }
        });
    }


    /**
     * Mark a vertex as and endpoint of an edge.
     * If markedVertices equals 2, an edge is adde betweeen the
     * marked vertices.
     *
     * @param xCord  x-coordinate of the vertex
     * @param yCord  y-coordinate of the vertex
     */
    private void markVertex(int xCord, int yCord){
        for(Vertex v : vertices){
            if(v.ellipse.contains(xCord, yCord)){
                v.marked = true;
                marked[markedVertices] = v;
                markedVertices++;
                if(markedVertices == 2){
                    Edge edge = new Edge(marked[0], marked[1]);
                    edges.add(edge);
                    marked[0].edges.add(edge);
                    marked[1].edges.add(edge);
                    marked[0].marked = false;
                    marked[1].marked = false;
                    markedVertices = 0;
                }
                break;
            }
        }
    }


    /**
     * Add a vertex to the list of vertices.
     *
     * @param xCord  x-coordinate of the vertex
     * @param yCord  y-coordinate of the vertex
     */
    private void addVertex(int xCord, int yCord){
        Vertex vert = new Vertex(xCord, yCord);
        vert.ellipse = new Ellipse2D.Double(xCord, yCord, 30, 30);
        vertices.add(vert);
    }


    /**
     * Painting the vertices and edges to the panel.
     *
     * If the vertex is marked, its serving as one endpoint of an edge.
     * Else the vertex is colored white.
     *
     * @param  g
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D comp =  (Graphics2D) g;
        comp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(Vertex v : vertices){
            if(!v.marked){
                comp.setColor(Color.BLACK);
                comp.draw(v.ellipse);
            }
            else {
                comp.setColor(Color.BLUE);
                comp.fill(v.ellipse);
            }
        }
        for(Edge e : edges){
            comp.drawLine( e.from.x, e.from.y, e.to.x, e.to.y);
        }
    }
}
