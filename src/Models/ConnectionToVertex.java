package Models;

/**
 * Created by Denis on 12.03.14.
 */
public class ConnectionToVertex implements Comparable<ConnectionToVertex> {
    public Vertex getVertex() {
        return vertex;
    }

    private Vertex vertex;
    public ConnectionToVertex(Vertex vertex){
        this.vertex = vertex;
    }

    @Override public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        if(this.getClass() != otherObject.getClass()){
            return false;
        }

        ConnectionToVertex other = (ConnectionToVertex) otherObject;
        return this.getVertex().equals(other.getVertex());
    }

    @Override
    public int compareTo(ConnectionToVertex other) {
        return this.getVertex().compareTo(other.getVertex());
    }
}
