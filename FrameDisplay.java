import javax.swing.*;

/**
 * Defines a frame a panel with the drawings will be added to.
 * 
 * @author Prof. Antonio Hernandez
 */

/**
 * Name:           Jose Iturria
 * Section:        COP4534, U01 - Algorithm Techniques
 * Panther ID:     5464894
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 750;
    int HEIGHT = 750;

    public FrameDisplay(Graph graph)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        GraphDisplay panel = new GraphDisplay(graph);
        add(panel);
    }
}
