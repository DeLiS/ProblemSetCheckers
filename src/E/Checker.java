package E;

import Models.SpiesSolution;
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
        String actual = output.nextLine().trim();
        SpiesSolution solution = new SpiesSolution();
        String expected;
        if(solution.solve(input)){
            expected = "Yes";
        }else{
            expected = "No";
        }
        return expected.equals(actual);
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
