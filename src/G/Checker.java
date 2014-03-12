package G;

import common.AbstractChecker;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Checker extends AbstractChecker {
    @Override
    public boolean checkIfAnswerIsCorrect(Scanner input, Scanner output) throws Exception {
        return false;
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
