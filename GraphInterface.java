/**
 * Name:           Jose Iturria
 * Section:        COP4534, U01 - Algorithm Techniques
 * Panther ID:     5464894
 */
public interface GraphInterface
{
    public void addEdge(int v, int w);
    public void removeEdge(int v, int w);
    public int[] findAdjacencyVertices(int v);
    public String toString();
}