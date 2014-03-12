package A;

import Models.MinesGraphModel;
import common.AbstractChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Checker extends AbstractChecker {

    public static void main(String[] args) {
        Checker checker = new Checker();
        int resultCode = checker.check(args);
        System.out.println(checker.getMessage());
        System.exit(resultCode);
    }


    @Override
    public Checker getChecker() {
        return new Checker();
    }

    @Override
    public boolean checkIfAnswerIsCorrect(Scanner inputScanner, Scanner outputScanner) throws Exception{
        MinesGraphModel fromMatrix = MinesGraphModel.fromMatrix(inputScanner);
        MinesGraphModel fromList = MinesGraphModel.fromList(outputScanner);
        boolean result = fromMatrix.equals(fromList);
        return result;
    }
}

