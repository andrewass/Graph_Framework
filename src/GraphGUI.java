
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

    JFrame frame;
    JPanel toppanel, midpanel, bottompanel;
    JButton compute;
    JComboBox menuselecter;
    JRadioButton addEdge, addVertex;
    ButtonGroup buttons;
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;
    private AlgorithmScheduler scheduler;
    private GridBagConstraints gbc = new GridBagConstraints();

    private String[] operations = {
            "Find Connected Components",
            "Minimum Spanning Tree"};


    GraphGUI(){
        frame = new JFrame("Graph GUI");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelSetup();
        frame.setVisible(true);
        scheduler = new AlgorithmScheduler(vertices, edges);
    }


    void panelSetup(){

        compute = new JButton("Calculate");

        compute.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                scheduler.decideAlgorithm(menuselecter.getSelectedItem().toString());
            }
        });

        menuselecter = new JComboBox(operations);
        toppanel = new JPanel();
        toppanel.add(menuselecter);
        toppanel.add(compute);
        toppanel.setSize(150,150);
        toppanel.setBackground(Color.GRAY);

        midpanel = new PaintPanel(this);
        midpanel.setSize(700,700);

        addVertex = new JRadioButton("Add Vertex");
        addEdge = new JRadioButton("Add Edge");
        buttons = new ButtonGroup();
        buttons.add(addEdge);
        buttons.add(addVertex);
        bottompanel = new JPanel();
        bottompanel.setSize(150,150);
        bottompanel.add(addVertex);
        bottompanel.add(addEdge);


        frame.add(toppanel, BorderLayout.NORTH);
        frame.add(midpanel, BorderLayout.CENTER);
        frame.add(bottompanel, BorderLayout.SOUTH);

    }


}
