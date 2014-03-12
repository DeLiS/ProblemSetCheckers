package B;

import Models.MinesGraphModel;
import common.AbstractChecker;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Checker extends AbstractChecker{

    public static void main(String[] args) {
        Checker checker = new Checker();
        int resultCode = checker.check(args);
        System.out.println(checker.getMessage());
        System.exit(resultCode);
    }
    @Override
    public boolean checkIfAnswerIsCorrect(Scanner input, Scanner output) throws Exception {
        MinesGraphModel fromList = MinesGraphModel.fromList(input);
        MinesGraphModel fromMatrix = MinesGraphModel.fromMatrix(output);
        boolean result = fromMatrix.equals(fromList);
        return result;
    }

    @Override
    public AbstractChecker getChecker() {
       return new Checker();
    }
}
