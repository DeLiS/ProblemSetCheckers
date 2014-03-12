package Models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 12.03.14.
 */
public class Vertex implements Comparable<Vertex> {
    public int getOrderNumberofVertex() {
        return orderNumberofVertex;
    }

    private int orderNumberofVertex;
    private List<ConnectionToVertex> adjacentVertexes = new LinkedList<ConnectionToVertex>();
    public Vertex(int orderNumberofVertex){
        this.orderNumberofVertex = orderNumberofVertex;
    }
    public void connect(Vertex vertex){
        ConnectionToVertex connectionToVertex = new ConnectionToVertex(vertex);
        if(!adjacentVertexes.contains(connectionToVertex)){
            adjacentVertexes.add(connectionToVertex);
        }
    }

    public void disconnect(Vertex vertex){
        ConnectionToVertex connectionToVertex = new ConnectionToVertex(vertex);
        adjacentVertexes.remove(connectionToVertex);
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        if(this.getClass() != otherObject.getClass()){
            return false;
        }
        Vertex other = (Vertex) otherObject;
        return this.getOrderNumberofVertex() == other.getOrderNumberofVertex();
    }

    @Override
    public int compareTo(Vertex other) {
        Integer thisNumber = this.getOrderNumberofVertex();
        Integer otherNumber = other.getOrderNumberofVertex();
        return thisNumber.compareTo(otherNumber);
    }
}
