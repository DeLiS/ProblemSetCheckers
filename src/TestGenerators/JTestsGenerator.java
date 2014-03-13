package TestGenerators;

import Models.Graph;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class JTestsGenerator extends AbstractTestGenerator {
    private final int maxN;
    private final Random random = new Random(System.currentTimeMillis());
    private int maxD;

    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxN = Integer.parseInt(args[2]);
        int maxD = Integer.parseInt(args[3]);
        ITestGenerator generator = new ITestGenerator(path, testsCount, maxN, maxD);
        generator.generate();

    }

    public JTestsGenerator(String path, int testsCount, int maxN, int maxD) throws IOException {
        super(path, testsCount);
        this.maxN = maxN;
        this.maxD = maxD;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int n = random.nextInt(maxN) + 1;
        int[][] matrix = GraphGenerator.createConnectedGraph(n, 1, maxD);
        String input = InputOutputFormatter.getJInput(n, matrix);
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }
}
