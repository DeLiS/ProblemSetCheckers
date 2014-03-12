package G;

import Models.Friendship;
import common.AbstractChecker;

import java.util.LinkedList;
import java.util.List;
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
        Friendship solution = new Friendship(input);
        List<Integer> expected = solution.getAnswers();
        List<Integer> actual = readList(output);
        if(expected.size() != actual.size()){
            return false;
        }
        for(int i = 0; i < expected.size(); ++i){
            if(!expected.get(i).equals(actual.get(i))){
                return false;
            }
        }
        return true;
    }

    private List<Integer> readList(Scanner output) {
        List<Integer> result = new LinkedList<Integer>();
        while(output.hasNextInt()){
            int number = output.nextInt();
            result.add(number);
        }
        return result;
    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
