package TestGenerators;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PairGenerator {
    static List<int[]> createPairsList(int numberOfVertixes) {
        List<int[]> list = new LinkedList<int[]>();
        for (int i = 0; i < numberOfVertixes; ++i) {
            for (int j = i + 1; j < numberOfVertixes; ++j) {
                list.add(new int[]{i, j});

            }
        }
        return list;
    }

    static int[] getNextPair(Random random, List<int[]> list) {
        int index = random.nextInt(list.size());
        int[] pair = list.get(index);
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        return pair;
    }
}