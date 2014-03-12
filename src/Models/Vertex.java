package Models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 12.03.14.
 */
public class Vertex implements Comparable<Vertex> {
    public int getNumber() {
        return number;
    }

    private int number;
    private List<Vertex> adjacentVertexes = new LinkedList<Vertex>();
    public Vertex(int number){
        this.number = number;
    }
    public void connect(Vertex vertex){
        if(!adjacentVertexes.contains(vertex)){
            adjacentVertexes.add(vertex);
        }
    }

    public void disconnect(Vertex vertex){
        adjacentVertexes.remove(vertex);
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
        return this.getNumber() == other.getNumber();
    }

    @Override
    public int compareTo(Vertex other) {
        Integer thisNumber = this.getNumber();
        Integer otherNumber = other.getNumber();
        return thisNumber.compareTo(otherNumber);
    }
}
