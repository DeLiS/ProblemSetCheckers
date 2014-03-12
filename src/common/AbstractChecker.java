package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public abstract class AbstractChecker {
    public static final int WA_CODE = 1;
    public static final int AC_CODE = 0;
    public static final int FAIL_CODE = 3;
    public static final String NO_INPUT_OR_OUTPUT_FILE = "No input or output file";
    public static final String AC = "AC";
    public static final String WA = "WA";
    private String message;
    protected static boolean accepted = false;

    public int check(String[] args){

        try{
            readFilesAndCheckIfAnswerIsCorrect(args);
        }catch (FileNotFoundException e){
            message = NO_INPUT_OR_OUTPUT_FILE;
            return FAIL_CODE;
        }catch (Exception e){
            accepted = false;
        }finally {
            return handleCorrectionCheckResult();
        }
    }

    private int handleCorrectionCheckResult() {
        if(accepted){
            message = AC;
            return AC_CODE;
        }else{
            message = WA;
            return WA_CODE;
        }
    }

    private void readFilesAndCheckIfAnswerIsCorrect(String[] args) throws Exception {
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        Scanner inputScanner = new Scanner(inputFile);
        Scanner outputScanner = new Scanner(outputFile);
        AbstractChecker checker = getChecker();
        accepted = checker.checkIfAnswerIsCorrect(inputScanner, outputScanner);
    }

    public abstract boolean checkIfAnswerIsCorrect(Scanner input, Scanner output) throws Exception;
    public abstract AbstractChecker getChecker();
    public String getMessage(){
        return message;
    }
}
