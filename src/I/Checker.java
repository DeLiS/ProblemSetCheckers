package I;

import Models.Synchrophasothron;
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
        Synchrophasothron synchrophasothron = new Synchrophasothron(input);
        String actual = output.nextLine();
        String expected;
        if(synchrophasothron.isPossible()){
            expected = "Y";
        }else{
            expected = "N";
        }
        return expected.equals(actual);
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
