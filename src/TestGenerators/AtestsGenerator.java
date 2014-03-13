package TestGenerators;

import Models.MinesGraphModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Denis on 13.03.14.
 */
public class AtestsGenerator extends AbstractTestGenerator {
    private final int maxN;
    private final int maxM;
    private MatrixGenerator matrixGenerator = new MatrixGenerator();

    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxN = Integer.parseInt(args[2]);
        int maxM = Integer.parseInt(args[3]);
        AtestsGenerator generator = new AtestsGenerator(path, testsCount, maxN, maxM);
        generator.generate();

    }

    public AtestsGenerator(String path, int testsCount, int maxN, int maxM) throws IOException {
        super(path, testsCount);
        this.maxN = maxN;
        this.maxM = maxM;
    }

    private void writeList(MinesGraphModel model, PrintWriter outputWriter) {
        String output = InputOutputFormatter.modelToBInput(model);
        outputWriter.print(output);

    }

    @Override
    protected void createInput(PrintWriter inputWriter) {
        int[][] matrix = matrixGenerator.generateOneMatrix(maxN, maxM,2);
        writeMatrix(matrix, inputWriter);
        inputWriter.flush();
        inputWriter.close();
    }

    private void writeMatrix(int[][] matrix, PrintWriter inputWriter) {
        String input = InputOutputFormatter.matrixToAInput(matrix);
        inputWriter.print(input);

    }
}
