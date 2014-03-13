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
        for(int i = 0; i < matrix.length; ++i){
            stringBuilder.append(NEW_LINE);
            for(int j = 0; j < matrix[i].length; ++j){
                if(j > 0){
                    stringBuilder.append(SPACE);
                }
                stringBuilder.append(matrix[i][j]);
            }
        }
        return stringBuilder.toString();
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
}
