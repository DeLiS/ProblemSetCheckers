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
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws IOException {

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
           writeOutputList(model, testNumber);
       }
    }

    private static void writeOutputList(MinesGraphModel model, int testNumber) {

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
        stringBuilder.append(" ");
        stringBuilder.append(ints[0].length);
        for(int i = 0; i < ints.length; ++i){
            stringBuilder.append("\n");
            for(int j = 0; j < ints[i].length; ++j){
                if(j > 0){
                    stringBuilder.append(" ");
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
            file.renameTo(new File(fileName + "_"));
        }

        file.createNewFile();
        return file;
    }

    private static String getInputFileName(String folderName) {
        StringBuilder fileNameBuilder = new StringBuilder(folderName);
        fileNameBuilder.append("\\in." + FOLDER_PREFIX + "xt");
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
        stringBuilder.append("\\");
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
