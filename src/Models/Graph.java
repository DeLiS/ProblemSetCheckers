package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 12.03.14.
 * Graph in which vertexes are numberd from 0 to numberOfVertexes - 1;
 */
public class Graph {
    private Vertex[] vertexes;
    private final int numberOfVertexes;

    public Graph(int numberOfVertexes){
        this.numberOfVertexes = numberOfVertexes;
        vertexes = new Vertex[numberOfVertexes];
        for(int i = 0; i < numberOfVertexes; ++i){
            vertexes[i] = new Vertex(i);
        }
    }

    public void connect(int start, int end){
        vertexes[start].connect(vertexes[end]);
    }


    public void disconnect(int start, int end){
        vertexes[start].disconnect(vertexes[end]);
    }

    public int[] adjacentVertexes(int vertexNumber){
        List<Vertex> adjacent = vertexes[vertexNumber].getAdjacentVertexes();
        int[] result = new int[adjacent.size()];
        for(int i = 0; i < result.length; ++i){
            result[i] = adjacent.get(i).getOrderNumberofVertex();
        }
        return result;
    }

    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }
}
