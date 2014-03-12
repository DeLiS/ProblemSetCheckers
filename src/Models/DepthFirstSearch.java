package Models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class DepthFirstSearch {
    private int numberOfVertexes;
    private int startRoom;
    private ArrayList<Integer> path;
    public DepthFirstSearch(Scanner input) {
        numberOfVertexes = input.nextInt();
        startRoom = input.nextInt();
        path = new ArrayList<Integer>(numberOfVertexes);

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
}

