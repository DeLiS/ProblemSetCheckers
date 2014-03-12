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
    public static final String FOLDER_PREFIX = "t";
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    public static final String OUTPUT_FILE_NAME = "out.txt";
    public static final String INPUT_FILE_NAME = "in.txt";
    public static final String DOUBLE_BACK_SLASH = "\\";
    public static final String UNDERSCORE = "_";
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {

        String outputFolder = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxN = Integer.parseInt(args[2]);
        int maxM = Integer.parseInt(args[3]);
        generateTests(outputFolder, testsCount, maxN, maxM);
        generateOutputs(outputFolder, testsCount);

    }

    private static void generateOutputs(String outputFolder, int testsCount) throws Exception {
       for(int testNumber = 0; testNumber < testsCount; ++testNumber){
           Scanner scanner = getInputScanner(outputFolder, testNumber);
           MinesGraphModel model = MinesGraphModel.fromMatrix(scanner);
           writeOutputList(model, outputFolder, testNumber);
       }
    }

    private static void writeOutputList(MinesGraphModel model,String outputFolder, int testNumber) throws IOException {
        File file = createOutputFile(outputFolder, testNumber);
        PrintWriter printWriter = new PrintWriter(file);
        StringBuilder result = new StringBuilder();

        addFirstLine(model, result);

        List<int[]> pairs = model.getList();
        for(int[] pair : pairs){
            addPair(pair, result);
        }
        String output = result.toString();
        printWriter.print(output);



    }

    private static void addPair(int[] pair, StringBuilder result) {
        result.append(NEW_LINE);
        result.append(pair[0]);
        result.append(SPACE);
        result.append(pair[1]);

    }

    private static void addFirstLine(MinesGraphModel model, StringBuilder result) {
        result.append(model.getNumberOfRows());
        result.append(SPACE);
        result.append(model.getNumberOfColumns());
        result.append(SPACE);
        result.append(model.getNumberOfMines());
    }

    private static File createOutputFile(String outputFolder, int testNumber) throws IOException {
        String outputFileName = getOutputFileName(outputFolder, testNumber);
        File file = recreateFile(outputFileName);
        return file;

    }

    private static String getOutputFileName(String outputFolder, int testNumber) {
        String testFolderName = getFolderName(outputFolder, testNumber);
        StringBuilder outputFileNameBuilder = new StringBuilder(testFolderName);
        outputFileNameBuilder.append(DOUBLE_BACK_SLASH + OUTPUT_FILE_NAME);
        return outputFileNameBuilder.toString();
    }

    private static Scanner getInputScanner(String outputFolder, int i) throws FileNotFoundException {
        String folderName = getFolderName(outputFolder, i);
        String inputFileName = getInputFileName(folderName);
        File file = new File(inputFileName);
        return new Scanner(file);
    }

    private static void generateTests(String outputFolder, int testsCount, int maxN, int maxM) throws IOException {
            List<int[][]> matrixes = getZeroOneMatrixes(testsCount, maxN, maxM);
            for(int i = 0; i < testsCount; ++i){
                createOutputFileAndWriteMatrix(outputFolder, matrixes, i);
            }
    }

    private static void createOutputFileAndWriteMatrix(String outputFolder, List<int[][]> matrixes, int i) throws IOException {
        File file = createFoldersAndFile(outputFolder, i);
        PrintWriter printWriter = new PrintWriter(file);
        writeMatrix(matrixes.get(i), printWriter);
    }

    private static void writeMatrix(int[][] ints, PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ints.length);
        stringBuilder.append(SPACE);
        stringBuilder.append(ints[0].length);
        for(int i = 0; i < ints.length; ++i){
            stringBuilder.append(NEW_LINE);
            for(int j = 0; j < ints[i].length; ++j){
                if(j > 0){
                    stringBuilder.append(SPACE);
                }
                stringBuilder.append(ints[i][j]);
            }
        }
        String output = stringBuilder.toString();
        printWriter.write(output);
        printWriter.flush();
        printWriter.close();
    }

    private static File createFoldersAndFile(String outputFolder, int i) throws IOException {
        String folderName = getFolderName(outputFolder, i);
        createFolderIfNotExists(folderName);
        String fileName = getInputFileName(folderName);
        File file = recreateFile(fileName);
        return file;
    }

    private static File recreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(file.exists()){
            file.renameTo(new File(fileName + UNDERSCORE));
        }

        file.createNewFile();
        return file;
    }

    private static String getInputFileName(String folderName) {
        StringBuilder fileNameBuilder = new StringBuilder(folderName);
        fileNameBuilder.append(DOUBLE_BACK_SLASH + INPUT_FILE_NAME);
        return fileNameBuilder.toString();
    }

    private static void createFolderIfNotExists(String folderName) {
        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdirs();
        }
    }

    private static String getFolderName(String outputFolder, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(outputFolder);
        stringBuilder.append(DOUBLE_BACK_SLASH);
        stringBuilder.append(FOLDER_PREFIX);
        stringBuilder.append(i);
        return stringBuilder.toString().trim();
    }


    public static List<int[][]> getZeroOneMatrixes(int count, int maxN, int maxM){

        int valueUpperLimit = 2;
        List<int[][]> result = new ArrayList<int[][]>(count);

        for(int i = 0; i < count; ++i){
            int[][] nextMatrix = generateOneMatrix( maxN,  maxM, valueUpperLimit);
            result.add(nextMatrix);
        }

        return result;
    }

    private static int[][] generateOneMatrix(int maxN, int maxM, int upperLimit) {
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
