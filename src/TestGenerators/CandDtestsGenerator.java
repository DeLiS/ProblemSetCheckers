package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class CandDtestsGenerator extends  AbstractTestGenerator{
    private final int maxNumberOfRooms;
    private Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxN = Integer.parseInt(args[2]);
        CandDtestsGenerator generator = new CandDtestsGenerator(path, testsCount, maxN);
        generator.generate();

    }

    public CandDtestsGenerator(String path, int testsCount, int maxNumberOfRooms) throws IOException {
        super(path, testsCount);
        this.maxNumberOfRooms = maxNumberOfRooms;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int numberOfRooms = random.nextInt(maxNumberOfRooms) + 1;
        int[][] matrix = GraphGenerator.createConnectedGraph(numberOfRooms, 1, 1);
        String input = InputOutputFormatter.matrixToAInput(matrix);
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();

    }
}
