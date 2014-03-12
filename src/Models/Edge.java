package Models;

/**
 * Created by Denis on 12.03.14.
 */
public class Edge implements Comparable<Edge> {
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    private int start;
    private int end;
    private int weight;


    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        if(this.getClass() != otherObject.getClass()){
            return false;
        }
        Edge other = (Edge) otherObject;

        return (this.start == other.start) && (this.end == other.end) && (this.weight == other.weight);
    }

    @Override
    public int compareTo(Edge other) {
        Integer thisWeight = this.weight;
        Integer otherWeight = other.weight;
        return thisWeight.compareTo(other.weight);
    }
}
