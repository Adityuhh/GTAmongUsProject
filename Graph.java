
import java.util.*;
import java.util.List;
public class Graph {

    private int numOfNodes;
    private boolean directed;
    private boolean weighted;
    private int[][] matrix;

    /*
    This will allow us to safely add weighted graphs in our class since
    we will be able to check whether an edge exists without relying
    on specific special values (like 0)
     */
    private boolean[][] isSetMatrix;

    // ...
    public Graph(int numOfNodes, boolean directed, boolean weighted) {

        this.directed = directed;
        this.weighted = weighted;
        this.numOfNodes = numOfNodes;

        // Simply initializes our adjacency matrix to the appropriate size
        matrix = new int[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
    }

    public void addEdge(int source, int destination) {

        int valueToAdd = 1;

        if (weighted) {
            valueToAdd = 0;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void addweight(int source, int destination, int weight) {

        int valueToAdd = weight;

        if (!weighted) {
            valueToAdd = 1;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                // We only want to print the values of those positions that have been marked as set
                if (isSetMatrix[i][j])
                    System.out.format("%8s", String.valueOf(matrix[i][j]));
                else System.out.format("%8s", "/  ");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numOfNodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numOfNodes; j++) {
                if (isSetMatrix[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public int getEdgeValue(int source, int destination) {

        return matrix[source][destination];
    }

    public int printVertices(){
        return numOfNodes;
    }

    /*
    public boolean ifTrue(int a, int b){ 
    if(getEdgeValue(a,b) != null){
    return true;
    }
    return false;
    }*/

    public boolean uniqueCharacters(String str)
    {
        // If at any time we encounter 2 same
        // characters, return false
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;

        // If no duplicate characters encountered,
        // return true
        return true;
    }

    public boolean lessThanN(String str)
    {

        for (int i = 0; i < str.length(); i++){
            if (Integer.parseInt(str.substring(i,i+1))>=str.length()){

                return false;

            }
        }

            return true;
        

    }
}

