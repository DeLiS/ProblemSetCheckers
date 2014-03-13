package TestGenerators;

import Models.MinesGraphModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Denis on 13.03.14.
 */
public class BtestsGenerator extends AbstractTestGenerator {

    private int maxRows;
    private int maxColumns;
    private MatrixGenerator matrixGenerator = new MatrixGenerator();


    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxN = Integer.parseInt(args[2]);
        int maxM = Integer.parseInt(args[3]);
        BtestsGenerator generator = new BtestsGenerator(path, testsCount, maxN, maxM);
        generator.generate();

    }

    public BtestsGenerator(String path, int testsCount, int maxRows, int maxColumns) throws IOException {
        super(path, testsCount);
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        MinesGraphModel model = createModel();
        String input = InputOutputFormatter.modelToBInput(model);
        writeInputAndCloseWriter(inputWriter, input);

    }

    private void writeInputAndCloseWriter(PrintWriter inputWriter, String input) {
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }

    private MinesGraphModel createModel() throws Exception {
        int[][] matrix = matrixGenerator.generateOneMatrix(maxRows, maxColumns, 2);
        String matrixInput = InputOutputFormatter.matrixToAInput(matrix);
        Scanner scanner = new Scanner(matrixInput);
        return MinesGraphModel.fromMatrix(scanner);
    }
}
