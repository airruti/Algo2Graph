import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Defines a panel the drawings will be made in.
 * 
 * @author Prof. Antonio Hernandez
 * 
 */

/**
 * Name:           Jose Iturria
 * Section:        COP4534, U01 - Algorithm Techniques
 * Panther ID:     5464894
 */
public class GraphDisplay extends JPanel
{
    int[][] matrix;
    int verticesNumber;
    int[] shortestPath;
    int s;
    int t;
    
    public GraphDisplay(Graph graph){
        this.matrix = graph.matrix;
        this.verticesNumber = graph.verticesNumber;
        this.s = graph.s;
        this.t = graph.t;
        this.shortestPath = graph.path;
    }

    /**
     * Paints the graph example.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g)
    {        
        int leftX = 100;
        int topY = 100;
        int width = 50;
        int height = 50;
        int labelX = 17;
        int labelY = 31;
        double angle = 0.0;
        //int[][] test = new int[verticesNumber][verticesNumber];

        //[0, 2, 3] s == 1, i, i + 1 == 1
        //1 0 1 0 0 
        //0 0 0 0 0
        //0 0 0 1 0    //this didnt work.. 
        //0 0 0 0 0
        //0 0 0 0 0

        // for (int i = 0; i < test.length; i++) {
        //     for (int j = 0; j < test.length; j++) {
        //         if ((j == t || j == s) && i == s){
        //             test[i][j] = 1;
        //         }
        //     }
        // }

        // System.out.println(Arrays.deepToString(test));

        //draw Edges
        for (int i = 0; i < verticesNumber ; i++) {
            leftX = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(i*(360.0/verticesNumber))))) + 300.0);
            topY = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(i*(360/verticesNumber))))) + 300.0);
            for (int j = 0; j < verticesNumber; j++) {
                if (matrix[i][j] != 0){
                    int leftX2 = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
                    int topY2 = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
                    g.setColor(Color.BLACK);
                    g.drawLine(leftX+height/2, topY+height/2, (leftX2)+height/2, (topY2)+height/2);
                }
            }
        }

        // //draw shortestPath
        // for (int i = 0; i < shortestPath.length; i++) {
        //     leftX = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(i*(360.0/verticesNumber))))) + 300.0);
        //     topY = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(i*(360/verticesNumber))))) + 300.0);
        //     for (int j = 0; j < shortestPath.length; j++) {
        //         if (matrix[i][j] != 0 && j == shortestPath[i] && j == shortestPath[j]){  //looking for some condition that draws the answer... didn't work...
        //             int leftX2 = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
        //             int topY2 = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
        //             g.setColor(Color.RED);
        //             g.drawLine(leftX+height/2, topY+height/2, (leftX2)+height/2, (topY2)+height/2);
        //         }
        //     }
        // }

        //draw shortestPath
        for (int i = 0; i < shortestPath.length - 1; i++) {
            int v1 = shortestPath[i];
            int v2 = shortestPath[i + 1]; //sometimes the correct solution is the simplest one.. 

            leftX = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(v1*(360.0/verticesNumber))))) + 300.0);
            topY = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(v1*(360/verticesNumber))))) + 300.0); 

            int leftX2 = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(v2*(360.0/verticesNumber))))) + 300.0);
            int topY2 = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(v2*(360.0/verticesNumber))))) + 300.0);

            g.setColor(Color.BLUE);
            g.drawLine(leftX+height/2, topY+height/2, (leftX2)+height/2, (topY2)+height/2);
        }


        //draw Nodes
        for(int i = 0; i < verticesNumber; i++){
            leftX = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(i*(360.0/verticesNumber))))) + 300.0);
            topY = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(i*(360.0/verticesNumber))))) + 300.0);
            g.setColor(Color.ORANGE);
            g.fillOval(leftX, topY, width, height);
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            g.drawString(String.valueOf(i), leftX+labelX, topY+labelY);
        }

        //draw weight
        for (int i = 0; i < verticesNumber ; i++) {
            leftX = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(i*(360.0/verticesNumber))))) + 300.0);
            topY = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(i*(360/verticesNumber))))) + 300.0);
            for (int j = 0; j < verticesNumber; j++) {
                if (matrix[i][j] != 0){
                    int leftX2 = (int)(250.0 * (Math.cos(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
                    int topY2 = (int)(250.0 * (Math.sin(((2*Math.PI)/360) * (angle+(j*(360.0/verticesNumber))))) + 300.0);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(matrix[i][j]), (leftX2 + leftX+height)/2, (topY2 + topY+height)/2);
                }
            }
        }

        //draw answer text
        g.setColor(Color.BLACK);
        g.drawString("Shortest Path: " + Arrays.toString(shortestPath), leftX + width, topY+ 2*height);
    }
}
