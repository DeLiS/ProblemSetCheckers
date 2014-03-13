package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class FtestsGenerator extends AbstractTestGenerator {

    private final int maxNumberOfTowns;
    private Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxNumberOfTowns = Integer.parseInt(args[2]);
        FtestsGenerator generator = new FtestsGenerator(path, testsCount, maxNumberOfTowns);
        generator.generate();

    }

    public FtestsGenerator(String path, int testsCount, int maxNumberOfTowns) throws IOException {
        super(path, testsCount);
        this.maxNumberOfTowns = maxNumberOfTowns;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int[][] matrix = createMatrix();
        String input = InputOutputFormatter.matrixToFinput(matrix);
        writeInput(inputWriter, input);
    }

    private int[][] createMatrix() {
        int numberOfTowns = random.nextInt(maxNumberOfTowns) + 1;
        int numberOfComponents = random.nextInt(numberOfTowns) + 1;
        int maxMatrixElement = 1;
        return GraphGenerator.createConnectedGraph(numberOfTowns, numberOfComponents, maxMatrixElement);
    }

    private void writeInput(PrintWriter inputWriter, String input) {
        inputWriter.write(input);
        inputWriter.flush();
        inputWriter.close();
    }
}
