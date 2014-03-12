package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Denis on 12.03.14.
 */
public abstract class AbstractGraphSearch {
    private int numberOfVertexes;
    private int startRoom;
    private ArrayList<Integer> path;
    private Graph graph;

    private boolean[] used;
    public AbstractGraphSearch(Scanner input) {
        numberOfVertexes = input.nextInt();
        used = new boolean[numberOfVertexes];
        startRoom = input.nextInt();
        path = new ArrayList<Integer>(numberOfVertexes);
        createGraph(input);

    }

    public AbstractGraphSearch(Graph graph, int start){
        numberOfVertexes = graph.getNumberOfVertexes();
        used = new boolean[numberOfVertexes];
        startRoom = start;
        path = new ArrayList<Integer>(numberOfVertexes);
        this.graph = graph;
    }

    public void run(){
        addVertexToSet(startRoom);
        while(!setIsEmpty()){
            int currentRoom = getNextVertex();
            if(!visited(currentRoom)){
                addToPath(currentRoom);
                used[currentRoom] = true;
                int[] adjacent = graph.adjacentVertexes(currentRoom);
                Arrays.sort(adjacent);
                addSortedAdjacentVertexesToSet(adjacent);
            }

        }
    }



    public boolean visited(int room) {
        return used[room] == true;
    }

    private void createGraph(Scanner input) {
        graph = new Graph(numberOfVertexes);
        for(int i = 0; i < numberOfVertexes; ++i){
            for(int j = 0; j < numberOfVertexes; ++j){
                int value = input.nextInt();
                if(value == 1){
                    graph.connect(i, j);
                    graph.connect(j, i);
                }
            }
        }
    }

    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int k : path){
            stringBuilder.append(k);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    public abstract void addVertexToSet(int vertex);
    public abstract boolean setIsEmpty();
    public abstract int getNextVertex();
    protected abstract void addSortedAdjacentVertexesToSet(int[] adjacent);
    private void addToPath(int room){
        path.add(room);
    }
}
