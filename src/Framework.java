import javax.swing.*;

/**
 * Created by Andreas Wassum on 8/28/17.
 *
 * Class responsible for initializing the graph framework.
 */
public class Framework {

    public static void main(String[] args){
        SwingUtilities.invokeLater(
                (new Runnable() {
                    @Override
                    public void run() {
                        new GraphGUI();
                    }
                })
        );
    }
}
