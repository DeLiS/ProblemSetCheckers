package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class HTestsGenerator extends AbstractTestGenerator {

    private final int maxNumberOfCities;
    private final int maxRiot;
    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxNumberOfCities = Integer.parseInt(args[2]);
        int maxRiot = Integer.parseInt(args[3]);
        HTestsGenerator generator = new HTestsGenerator(path, testsCount, maxNumberOfCities, maxRiot);
        generator.generate();

    }

    public HTestsGenerator(String path, int testsCount, int maxNumberOfCities, int maxRiot) throws IOException {
        super(path, testsCount);
        this.maxNumberOfCities = maxNumberOfCities;
        this.maxRiot = maxRiot;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int numberOfCities = random.nextInt(maxNumberOfCities) + 1;
        int riot = random.nextInt(maxRiot - 1) + 1;
        int[][] matrix = GraphGenerator.createConnectedGraph(numberOfCities, 1, riot * (1 + random.nextInt(2))); // random = 0 guaranties good test
        String input = InputOutputFormatter.getHInput(numberOfCities, riot, matrix);
        writeInput(inputWriter, input);
    }

    private void writeInput(PrintWriter inputWriter, String input) {
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }
}
