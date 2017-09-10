import javax.swing.*;
import java.awt.*;

/**
 * Created by Andreas Wassum on 8/28/17.
 */
public class GraphGUI {

    JFrame frame;
    JPanel toppanel, midpanel, bottompanel;
    JButton addVertex, addEdge, compute;
    GridBagConstraints gbc = new GridBagConstraints();

    GraphGUI(){
        frame = new JFrame("Graph GUI");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLayout(new FlowLayout());
        panelSetup();
        frame.setVisible(true);
    }


    void panelSetup(){

        compute = new JButton("Caluclate");
        toppanel = new JPanel();
        toppanel.add(compute);
        toppanel.setSize(150,150);
        toppanel.setBackground(Color.GRAY);

        midpanel = new PaintPanel();
        midpanel.setSize(700,700);

        addVertex = new JButton("Add Vertex");
        addEdge = new JButton("Add Edge");
        bottompanel = new JPanel();
        bottompanel.setSize(150,150);
        bottompanel.add(addVertex);
        bottompanel.add(addEdge);


        frame.add(toppanel, BorderLayout.NORTH);
        frame.add(midpanel, BorderLayout.CENTER);
        frame.add(bottompanel, BorderLayout.SOUTH);

    }


}
