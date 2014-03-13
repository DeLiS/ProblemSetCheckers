package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Denis on 13.03.14.
 */
public class JTestsGenerator extends AbstractTestGenerator {
    public JTestsGenerator(String path, int testsCount) throws IOException {
        super(path, testsCount);
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {

    }
}
