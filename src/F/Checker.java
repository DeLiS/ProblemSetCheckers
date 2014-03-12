package F;

import Models.CitiesRoadsSolution;
import common.AbstractChecker;

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
    public boolean checkIfAnswerIsCorrect(Scanner input, Scanner output) throws Exception {
        CitiesRoadsSolution solution = new CitiesRoadsSolution(input);
        int expected = solution.solve();
        int actual = output.nextInt();
        return expected == actual;
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
