package Models;

import java.util.*;

/**
 * Created by Denis on 12.03.14.
 */
public class DepthFirstSearch extends AbstractGraphSearch {

    private Stack<Integer> stack = new Stack<Integer>();
    public DepthFirstSearch(Scanner input) {
        super(input);

    }

    public DepthFirstSearch(Graph graph, int start){
        super(graph, start);
    }

    @Override
    public void addVertexToSet(int vertex) {
        stack.add(vertex);
    }

    @Override
    public boolean setIsEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int getNextVertex() {
        return stack.pop();
    }

    @Override
    protected void addSortedAdjacentVertexesToSet(int[] adjacent) {
        for (int i = adjacent.length - 1; i >= 0; i--) {
            int room = adjacent[i];
            if (!visited(room)) {
                stack.add(room);
            }
        }
    }


}

