
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GraphAlgorithms.Edge;
import GraphAlgorithms.Vertex;
import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 8/28/17.
 */
public class GraphGUI {

    private JFrame frame;
    private JPanel toppanel, bottompanel;
    PaintPanel midpanel;
    private JButton compute, clear, reset;
    private JComboBox menuselecter;
    JRadioButton addEdge, addVertex;
    private ButtonGroup buttons;
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;
    private AlgorithmScheduler scheduler;

    private String[] operations = {
            "Connected Components",
            "Graph Coloring",
            "Minimum Spanning Tree"};


    GraphGUI(){
        frame = new JFrame("Graph GUI");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelSetup();
        frame.setVisible(true);
        scheduler = new AlgorithmScheduler(vertices, edges);
    }

    /**
     * Setup of the top-, mid- and bottom panel in the JFrame object.
     */
    private void panelSetup(){
        toppanel = new JPanel();
        midpanel = new PaintPanel(this);
        bottompanel = new JPanel();
        setUpTopPanel();
        midpanel.setSize(700,700);
        frame.add(midpanel, BorderLayout.CENTER);
        setUpBottomPanel();
    }

    /**
     * Setup up of the top panel in the JFrame
     */
    private void setUpTopPanel(){
        compute = new JButton("Calculate");
        compute.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                scheduler.decideAlgorithm(menuselecter.getSelectedItem().toString());
                midpanel.repaint();
            }
        });
        menuselecter = new JComboBox(operations);
        reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                midpanel.colorReset();
            }
        });
        toppanel.add(menuselecter);
        toppanel.add(compute);
        toppanel.add(reset);
        toppanel.setSize(150,150);
        toppanel.setBackground(Color.GRAY);
        frame.add(toppanel, BorderLayout.NORTH);
    }


    /**
     * Setup of the bottom panel in the JFrame
     */
    private void setUpBottomPanel(){
        addVertex = new JRadioButton("Add Vertex");
        addEdge = new JRadioButton("Add Edge");
        buttons = new ButtonGroup();
        buttons.add(addEdge);
        buttons.add(addVertex);
        clear = new JButton("Clear Graph");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edges.clear();
                vertices.clear();
                midpanel.repaint();
            }
        });
        bottompanel.setSize(150,150);
        bottompanel.add(addVertex);
        bottompanel.add(addEdge);
        bottompanel.add(clear);
        frame.add(bottompanel, BorderLayout.SOUTH);
    }
}
