package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class MinesGraphModel {
    public static final String WRONG_NUMBER_OF_MINES = "Wrong number of mines";
    public static final String WRONG_MATRIX_SIZE = "Wrong matrix size";
    public static final String WRONG_MATRIX_VALUE = "Wrong matrix value";
    private int n;
    private int m;
    private int numberOfMines;
    private int[][] matrix;

    private MinesGraphModel(){}

    public static MinesGraphModel fromMatrix(Scanner input) throws Exception {
        MinesGraphModel model = initModel(input);
        readMatrixAndCalcMines(model, input);
        return model;
    }

    public static MinesGraphModel fromList(Scanner input) throws Exception{
        MinesGraphModel model = initModel(input);
        readK(input, model);
        readList(model, input);
        checkEndOfInput(input);
        return model;
    }

    public  List<int[]> getList(){
        List<int[]> result = new ArrayList<int[]>(numberOfMines);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                result.add(new int[]{i,j});
            }
        }
        return result;
    }

    private static void readK(Scanner input, MinesGraphModel model) throws Exception {
        model.numberOfMines = input.nextInt();
        checkNumberOfMines(model);
    }

    private static void checkNumberOfMines(MinesGraphModel model) throws Exception {
        if(model.getNumberOfMines() <0 || model.getNumberOfMines() > model.getNumberOfRows() * model.getNumberOfColumns()){
            throw new Exception(WRONG_NUMBER_OF_MINES);
        }
    }

    private static void checkEndOfInput(Scanner input) throws Exception {
        if(input.hasNext()){
            throw new Exception(WRONG_NUMBER_OF_MINES);
        }
    }

    private static void readList(MinesGraphModel model, Scanner input) throws Exception {
        for(int i = 0; i < model.getNumberOfMines(); ++i){
            if(!input.hasNext()){
                throw new Exception(WRONG_NUMBER_OF_MINES);
            }
            readNextMine(model, input);
        }
    }

    private static void readNextMine(MinesGraphModel model, Scanner input) {
        int row = input.nextInt();
        int col = input.nextInt();
        model.matrix[row][col] = 1;
    }

    private static void readMatrixAndCalcMines(MinesGraphModel model, Scanner input) throws Exception {
        for(int i = 0; i < model.getNumberOfColumns(); ++i){
            for(int j = 0; j < model.getNumberOfRows(); ++j){
                int value = input.nextInt();
                checkMatrixValue(value);
                if(value == 1){
                    model.numberOfMines++;
                }
                model.matrix[i][j] = value;
            }
        }
    }

    private static void checkMatrixValue(int value) throws Exception {
        if(value != 0 && value != 1){
            throw new Exception(WRONG_MATRIX_VALUE);
        }
    }

    private static MinesGraphModel initModel(Scanner input) throws Exception {
        MinesGraphModel model = new MinesGraphModel();
        readMatrixSize(input, model);
        checkMatrixSize(model.n, model.m);
        createMatrix(model);
        return model;
    }

    private static void createMatrix(MinesGraphModel model) {
        model.matrix = new int[model.getNumberOfColumns()][model.getNumberOfRows()];
    }

    private static void readMatrixSize(Scanner input, MinesGraphModel model) {
        model.n = input.nextInt();
        model.m = input.nextInt();
    }

    private static void checkMatrixSize(int n, int m) throws Exception {
        if(n <= 0 || m <= 0){
            throw new Exception(WRONG_MATRIX_SIZE);
        }
    }

    @Override public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }
        if(otherObject == null){
            return false;
        }
        if(getClass() != otherObject.getClass()){
            return false;
        }
        MinesGraphModel other = (MinesGraphModel)otherObject;

        return equalSizes(other) && equalNumberOfMines(other) && equalMatrixes(other);
    }

    private boolean equalMatrixes(MinesGraphModel other) {
        return Arrays.deepEquals(this.getMatrix(), other.getMatrix());
    }

    private boolean equalNumberOfMines(MinesGraphModel other) {
        return getNumberOfMines() == other.getNumberOfMines();
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    private boolean equalSizes(MinesGraphModel other) {
        return getNumberOfColumns() == other.getNumberOfColumns() && getNumberOfRows() == other.getNumberOfRows();
    }

    public int getNumberOfRows() {
        return m;
    }

    public int getNumberOfColumns() {
        return n;
    }


    public int[][] getMatrix() {
        return matrix;
    }
}
