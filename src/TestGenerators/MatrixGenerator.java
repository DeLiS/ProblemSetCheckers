package TestGenerators;

import Models.MinesGraphModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 * For problem A
 */
public class MatrixGenerator {

    private static Random random = new Random(System.currentTimeMillis());

    public List<int[][]> getZeroOneMatrixes(int count, int maxN, int maxM){

        int valueUpperLimit = 2;
        List<int[][]> result = new ArrayList<int[][]>(count);

        for(int i = 0; i < count; ++i){
            int[][] nextMatrix = generateOneMatrix( maxN,  maxM, valueUpperLimit);
            result.add(nextMatrix);
        }

        return result;
    }

    public int[][] generateOneMatrix(int maxN, int maxM, int upperLimit) {
        int n = random.nextInt(maxN) + 1;
        int m = random.nextInt(maxM) + 1;
        int[][] result = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                result[i][j] = random.nextInt(upperLimit);
            }
        }
        return result;
    }


}
