package TestGenerators;

import Models.MinesGraphModel;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * Created by Denis on 13.03.14.
 */
public class InputOutputFormatter {

    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static String matrixToAInput(int[][] matrix){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matrix.length);
        stringBuilder.append(SPACE);
        stringBuilder.append(matrix[0].length);
        matrixToStringBuilder(matrix, stringBuilder);
        return stringBuilder.toString();
    }

    private static void matrixToStringBuilder(int[][] matrix, StringBuilder stringBuilder) {
        for(int i = 0; i < matrix.length; ++i){
            stringBuilder.append(NEW_LINE);
            for(int j = 0; j < matrix[i].length; ++j){
                if(j > 0){
                    stringBuilder.append(SPACE);
                }
                stringBuilder.append(matrix[i][j]);
            }
        }
    }

    public static String modelToBInput(MinesGraphModel model){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(model.getNumberOfRows());
        stringBuilder.append(SPACE);
        stringBuilder.append(model.getNumberOfColumns());
        stringBuilder.append(SPACE);
        stringBuilder.append(model.getNumberOfMines());

        List<int[]> mines = model.getList();
        for(int i = 0; i < mines.size(); ++i){
            int[] pair = mines.get(i);
            stringBuilder.append(NEW_LINE);
            stringBuilder.append(pair[0]);
            stringBuilder.append(SPACE);
            stringBuilder.append(pair[1]);
        }
        return stringBuilder.toString();
    }

    public static String languagesToEInput(int k, int m, List<List<Integer>> languages) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k);
        stringBuilder.append(SPACE);
        stringBuilder.append(m);
        for(int i = 0; i < languages.size(); ++i){
            stringBuilder.append(NEW_LINE);
            List<Integer> langs = languages.get(i);
            stringBuilder.append(langs.size());
            for(int j = 0; j < langs.size(); ++j){
                stringBuilder.append(SPACE);
                stringBuilder.append(langs.get(j));
            }
        }
        return stringBuilder.toString();

    }

    public static String matrixToFinput(int[][] matrix) {
        int k = countOnes(matrix);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matrix.length);
        stringBuilder.append(SPACE);
        stringBuilder.append(k);
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                if(matrix[i][j] == 1){
                    stringBuilder.append(NEW_LINE);
                    stringBuilder.append(i);
                    stringBuilder.append(SPACE);
                    stringBuilder.append(j);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static int countOnes(int[][] matrix) {
        int k = 0;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                if(matrix[i][j] == 1){
                    ++k;
                }
            }
        }
        return k;
    }

    public static String queriesToGInput(int numberOfChildren, int numberOfQueries, int[][] queries) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfChildren);
        stringBuilder.append(SPACE);
        stringBuilder.append(numberOfQueries);
        for(int i = 0;i < queries.length; ++i){
            stringBuilder.append(NEW_LINE);
            stringBuilder.append(queries[i][0]);
            stringBuilder.append(SPACE);
            stringBuilder.append(queries[i][1]);
            stringBuilder.append(SPACE);
            stringBuilder.append(queries[0][2]);
        }
        return stringBuilder.toString();
    }

    public static String getHInput(int numberOfCities, int riot, int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfCities);
        stringBuilder.append(SPACE);
        stringBuilder.append(riot);
        matrixToStringBuilder(matrix, stringBuilder);
        return stringBuilder.toString();
    }

    public static String getIInput(int k, int n, int[][] connections) {

        int m = calcNumberOfConnections(connections);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k);
        stringBuilder.append(SPACE);
        stringBuilder.append(n);
        stringBuilder.append(SPACE);
        stringBuilder.append(m);
        matrixToStringBuilderAsList(connections, stringBuilder);
        return stringBuilder.toString();
    }

    private static int calcNumberOfConnections(int[][] connections) {
        int res = 0;
        for(int i = 0; i < connections.length; ++i){
            for(int j = 0; j < connections[i].length; ++j){
                if(connections[i][j] > 0){
                    res++;
                }
            }
        }
        return res;
    }

    private static void matrixToStringBuilderAsList(int[][] connections, StringBuilder stringBuilder) {
        for(int i = 0; i < connections.length; ++i){
            for(int j = 0; j < connections[i].length; ++j){
                if(connections[i][j] > 0){
                    stringBuilder.append(NEW_LINE);
                    stringBuilder.append(i);
                    stringBuilder.append(SPACE);
                    stringBuilder.append(j);
                    stringBuilder.append(SPACE);
                    stringBuilder.append(connections[i][j]);
                }
            }
        }
    }

    public static String getJInput(int n, int[][] matrix) {
        int m = calcNumberOfConnections(matrix);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(SPACE);
        stringBuilder.append(m);
        matrixToStringBuilderAsList(matrix, stringBuilder);
        return stringBuilder.toString();
    }
}
