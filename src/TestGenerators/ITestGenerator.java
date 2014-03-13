package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class ITestGenerator extends AbstractTestGenerator {
    private final int maxStress;
    private final int maxDetails;
    private final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxStress = Integer.parseInt(args[2]);
        int maxDetails = Integer.parseInt(args[3]);
        ITestGenerator generator = new ITestGenerator(path, testsCount, maxStress, maxDetails);
        generator.generate();

    }

    public ITestGenerator(String path, int testsCount, int maxStress, int maxDetails) throws IOException {
        super(path, testsCount);
        this.maxStress = maxStress;
        this.maxDetails = maxDetails;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int k = random.nextInt(maxStress) + 1;
        int n = random.nextInt(maxDetails) + 1;
        int[][] connections = GraphGenerator.createConnectedGraph(n, 1, 99);
        String input = InputOutputFormatter.getIInput(k, n, connections);
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }

}
