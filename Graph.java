import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Implements a Graph. Uses an adjacency matrix to represent the graph.
 *
 * @author Prof. Antonio Hernandez
 */

/**
 * Name:           Jose Iturria
 * Section:        COP4534, U01 - Algorithm Techniques
 * Panther ID:     5464894
 */
public class Graph implements GraphInterface
{
    public  int verticesNumber;
    public  int[][] matrix; //adjacency matrix
    public  int s;
    public  int t;
    public  int[] path;
    public  int[] d;
    
    /**
     * Instantiates a graph and initializes it with info from a text file.
     *
     * @param filename text file with graph info
     */
    public Graph(String filename)
    {
        File input = new File(filename);
        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
        int verticesNumber=0;

        while (in.hasNextLine())
        {
            verticesNumber = in.nextInt();
            matrix = new int[verticesNumber][verticesNumber];
            System.out.println("Number of vertices: " + verticesNumber);

            for(int i=0; i<verticesNumber; i++)
            {
                for(int j=0; j<verticesNumber; j++)
                {
                    //mat_i_j = in.nextInt();
                    this.matrix[i][j] = in.nextInt();
                    //System.out.print(mat_i_j + " ");
                }
                //System.out.println();
            }

            this.s = in.nextInt();
            this.t = in.nextInt();
            System.out.println("Source: " + s + ", End: " + t);

        }
        in.close();

        this.verticesNumber = verticesNumber;

        this.path = new int[verticesNumber];
        this.d = new int[verticesNumber];

        allShortestPaths(path, d, s);
        this.path = getPath(s, t, path);

        System.out.println("Shortest Path: " + Arrays.toString(path));

    }

    public int[] getPath(int s, int t, int [] p){
        int [] shortestPath = new int[p.length];

        int current = t;
        int total = 0;
        while (current != s){
            shortestPath[total] = current;
            current = p[current];
            total++;
        }

        shortestPath[total++] = s;
        shortestPath = Arrays.copyOf(shortestPath, total);

        for (int i = 0; i < total/2; i++) {
            int temp = shortestPath[i];
            shortestPath[i] = shortestPath[total-1-i];
            shortestPath[total-1-i] = temp;
        }

        return shortestPath;
    }

    public void addEdge(int v, int w)
    {
        matrix[v][w] = 1;
        matrix[w][v] = 1;
    }

    public void removeEdge(int v, int w)
    {
        matrix[v][w] = 0;
        matrix[w][v] = 0;
    }

    /**
     * Finds vertices adjacent to a given vertex.
     *
     * @param v given vertex
     * @return list of vertices adjacent to v stored in an array;
     *          size of array = number of adjacent vertices
     */
    public int[] findAdjacencyVertices(int v)
    {
        int[] vert = new int[verticesNumber];
        int total = 0;

        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                vert[total] = i;
                total++;
            }
        }

        return Arrays.copyOf(vert, total);
    }

    public void allShortestPaths(int[] p, int[] d, int v){
        boolean[] visited = new boolean[verticesNumber];

        for (int i = 0; i < verticesNumber; i++) {
                visited[i] = false;
                p[i] = -1;
                d[i] = Integer.MAX_VALUE;
        }

        d[v] = 0;

        for (int i = 0; i < verticesNumber; i++) {
                int w = minDistance(visited, d);
                visited[w] = true;

                int[] adj = findAdjacencyVertices(w);

                for (int u : adj) {
                    if (!visited[u]){
                        if (d[w] + matrix[w][u] < d[u]){
                            d[u] = d[w] + matrix[w][u];
                            p[u] = w;
                        }
                    }
                }
        }
    }

    private int minDistance(boolean[] visited, int[] distance){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < verticesNumber; i++) {
                if (!visited[i]){
                    if (distance[i] <= min){
                        min = distance[i];
                        index = i;
                    }
                }
        }
        return index;
    }
}