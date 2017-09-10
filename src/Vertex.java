import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

/**
 * Created by Andreas Wassum on 8/30/17.
 */
public class Vertex {
    int x,y;
    boolean marked = false;

    Vertex(int x, int y){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
        });
        this.x = x;
        this.y = y;
    }
}
