package TestGenerators;

import Models.DisjointSetUnion;
import Models.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class GraphGenerator {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createConnectedGraph(5, 1, 3)));
    }
    public static int[][] createConnectedGraph(int numberOfVertixes, int requiredNumberOfConnectedComponents, int maxWeight){
        int currentNumberOfConnectedComponents = numberOfVertixes;
        DisjointSetUnion dsu = new DisjointSetUnion(numberOfVertixes);
        Random random = new Random(System.currentTimeMillis());
        int[][] matrix = new int[numberOfVertixes][numberOfVertixes];
        List<int[]> list = createPairsList(numberOfVertixes);


        createGraphMatrix(requiredNumberOfConnectedComponents, maxWeight, currentNumberOfConnectedComponents, dsu, random, matrix, list);
        return matrix;
    }

    private static void createGraphMatrix(int requiredNumberOfConnectedComponents, int maxWeight, int currentNumberOfConnectedComponents, DisjointSetUnion dsu, Random random, int[][] matrix, List<int[]> list) {
        while(currentNumberOfConnectedComponents != requiredNumberOfConnectedComponents){
            int[] pair = getNextPair(random, list);
            int a = pair[0];
            int b = pair[1];

            matrix[a][b] = matrix[b][a] = random.nextInt(maxWeight) + 1;
            if(!dsu.areInTheSameSet(a, b)){
                dsu.uniteSetsOf(a, b);
                currentNumberOfConnectedComponents -= 1;
            }

        }
    }

    private static List<int[]> createPairsList(int numberOfVertixes) {
        List<int[]> list = new LinkedList<int[]>();
        for(int i = 0; i < numberOfVertixes; ++i){
            for(int j = i + 1; j < numberOfVertixes; ++j){
                list.add(new int[]{i, j});

            }
        }
        return list;
    }

    private static int[] getNextPair(Random random, List<int[]> list) {
        int index = random.nextInt(list.size());
        int[] pair = list.get(index);
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        return pair;
    }
}
