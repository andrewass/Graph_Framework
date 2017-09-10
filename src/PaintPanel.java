import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by Andreas Wassum on 8/30/17.
 */
public class PaintPanel extends JPanel {

    private ArrayList<Vertex> vertices = new ArrayList();
    private ArrayList<Ellipse2D.Double> circles = new ArrayList<>();

    /**
     * Adding a Point object every time the panel is clicked
     */
    PaintPanel(){
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                vertices.add(new Vertex(e.getX(), e.getY()));
                circles.add(new Ellipse2D.Double(e.getX(), e.getY(), 30, 30));
                repaint();
            }
        });
    }


    /**
     * Painting the nodes to the panel
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D comp =  (Graphics2D) g;
        comp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        comp.setColor(Color.BLACK);
        for(Ellipse2D.Double circle : circles){
            comp.draw(circle);
        }
    }
}
