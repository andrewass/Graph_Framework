import javax.swing.*;
import java.awt.*;

/**
 * Created by Andreas Wassum on 8/28/17.
 */
public class GraphGUI {

    JFrame frame;
    JPanel panel;
    JButton addVertex, addEdge;

    GraphGUI(){
        frame = new JFrame("Graph GUI");
        frame.setSize(600,600);
        panelSetup();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    void panelSetup(){
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        addVertex = new JButton("Add Vertex");
        addEdge = new JButton("Add Edge");
        panel.add(addVertex);
        panel.add(addEdge);
        frame.add(panel);
    }


}
