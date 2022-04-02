
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Illustrates reading graph from text file.
 *
 * @author Prof. Hernandez
 */
public class ReadInputFromTextFile
{
    public static void main(String[] args)
    {
        new ReadInputFromTextFile();
    }

    public ReadInputFromTextFile()
    {
        readGraph();
    }

    /**
     * Reads graph from text file (entries as given in COP4534 3rd assignment)
     * and prints it
     */

    public void readGraph()
    {
        File input = new File("graph 01.txt");
        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
        int numberOfVertices=0;
        int mat_i_j=0;

        while (in.hasNextLine())
        {
            numberOfVertices = in.nextInt();
            System.out.println(numberOfVertices);

            for(int i=0; i<numberOfVertices; i++)
            {
                for(int j=0; j<numberOfVertices; j++)
                {
                    mat_i_j = in.nextInt();
                    System.out.print(mat_i_j + " ");
                }
                System.out.println();
            }

            int s = in.nextInt();
            int t = in.nextInt();
            System.out.println(s + " " + t);
        }

        in.close();
    }
}