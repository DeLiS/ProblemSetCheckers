package Models;

import java.util.*;

/**
 * Created by Denis on 12.03.14.
 */
public class BreadthFirstSearch extends AbstractGraphSearch {
    private Queue<Integer> queue = new LinkedList<Integer>();

    public BreadthFirstSearch(Scanner input) {
        super(input);

    }

    @Override
    public void addVertexToSet(int vertex) {
        queue.add(vertex);
    }

    @Override
    public boolean setIsEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int getNextVertex() {
        return queue.poll();
    }

    @Override
    protected void addSortedAdjacentVertexesToSet(int[] adjacent) {
        for (int i = 0; i <= adjacent.length; i++) {
            int room = adjacent[i];
            if (!visited(room)) {
                queue.add(room);
                addToPath(room);
            }
        }
    }


}
