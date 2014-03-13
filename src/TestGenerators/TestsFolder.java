package TestGenerators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Denis on 13.03.14.
 */
public class TestsFolder {

    public static final String FOLDER_PREFIX = "t";
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    public static final String DOUBLE_BACK_SLASH = "\\";
    public static final String UNDERSCORE = "_";
    public static final String OUTPUT_FILE_NAME = "out.txt";
    public static final String INPUT_FILE_NAME = "in.txt";

    private String absolutePath;
    private File testFolder;
    private int testsCount;

    public TestsFolder(String absolutePath, int testsCount) throws IOException {
        this.absolutePath = absolutePath;
        makeSureThatExistsFolder(absolutePath);
        for(int i = 0; i < testsCount; ++i){
            String folder = getAbsoluteNameNameOfTestSubfolderNo(i);
            makeSureThatExistsFolder(folder);
            recreateInputAndOutputFilesForTest(i);
        }
    }

    public void recreateInputAndOutputFilesForTest(int i) throws IOException {
        File input = getInputFileForTestNo(i);
        File output = getOutputFileForTestNo(i);
        recreate(input);
        recreate(output);

    }

    private void recreate(File input) throws IOException {
        if (input.exists()) {
            input.delete();
        }
        input.createNewFile();
    }

    public PrintWriter getWriterForTestInputNo(int n) throws FileNotFoundException {
        File file = getInputFileForTestNo(n);
        return new PrintWriter(file);
    }

    public PrintWriter getWriterForTestOutputNo(int n) throws FileNotFoundException {
        File file = getOutputFileForTestNo(n);
        return new PrintWriter(file);
    }

    public Scanner getScannerForTestInputNo(int n) throws FileNotFoundException {
        File file = getInputFileForTestNo(n);
        return new Scanner(file);
    }

    public Scanner getScannerForTestOutputNo(int n) throws FileNotFoundException {
        File file = getOutputFileForTestNo(n);
        return new Scanner(file);
    }
    private void makeSureThatExistsFolder(String absolutePath){
        File file = getFileForFolder(absolutePath);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    private File getFileForFolder(String absolutePath){
        return new File(absolutePath);
    }

    private String getAbsoluteNameNameOfTestSubfolderNo(int n){
        return absolutePath + DOUBLE_BACK_SLASH + FOLDER_PREFIX + n;
    }

    private String getInputFileAbsoluteNameForTestNo(int n){
        String folder = getAbsoluteNameNameOfTestSubfolderNo(n);
        return folder + DOUBLE_BACK_SLASH + INPUT_FILE_NAME;
    }

    private String getOutputFileAbsoluteNameForTestNo(int n){
        String folder = getAbsoluteNameNameOfTestSubfolderNo(n);
        return folder + DOUBLE_BACK_SLASH + OUTPUT_FILE_NAME;
    }

    private File getOutputFileForTestNo(int n){
        String outputPath = getOutputFileAbsoluteNameForTestNo(n);
        return new File(outputPath);
    }

    private File getInputFileForTestNo(int n){
        String inputPath = getInputFileAbsoluteNameForTestNo(n);
        return new File(inputPath);
    }
}
