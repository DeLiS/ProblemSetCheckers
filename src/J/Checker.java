package J;

import Models.Tunnels;
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
        Tunnels tunnels = new Tunnels(input);
        long expected = tunnels.getAnswer();
        long actual = output.nextLong();
        return expected == actual;
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
