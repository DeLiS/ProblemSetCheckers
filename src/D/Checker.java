package D;

import Models.BreadthFirstSearch;
import Models.DepthFirstSearch;
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
        BreadthFirstSearch dfs = new BreadthFirstSearch(input);
        dfs.run();
        int numberOfVisitedVertexes = dfs.getNumberOfVertexes();
        String path = dfs.getPath().trim();

        int k = output.nextInt();
        output.nextLine();
        String outputPath = output.nextLine().trim();

        return k == numberOfVisitedVertexes && path.equals(outputPath);


    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
