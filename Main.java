import javax.swing.JFrame;

/**
 * Name:           Jose Iturria
 * Section:        COP4534, U01 - Algorithm Techniques
 * Panther ID:     5464894
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph("graph.txt");

        FrameDisplay frame = new FrameDisplay(graph);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
