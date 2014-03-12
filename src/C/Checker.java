package C;

import Models.DepthFirstSearch;
import common.AbstractChecker;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Checker extends AbstractChecker {
    @Override
    public boolean checkIfAnswerIsCorrect(Scanner input, Scanner output) throws Exception {
        DepthFirstSearch dfs = new DepthFirstSearch(input);
        int numberOfVisitedVertexes = dfs.getNumberOfVertexes();
        String path = dfs.getPath().trim();

        int k = output.nextInt();
        String outputPath = output.nextLine().trim();

        return k == numberOfVisitedVertexes && path.equals(outputPath);


    }

    @Override
    public AbstractChecker getChecker() {
        return new Checker();
    }
}
