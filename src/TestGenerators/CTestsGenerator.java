package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Denis on 13.03.14.
 */
public class CTestsGenerator extends  AbstractTestGenerator{
    public CTestsGenerator(String path, int testsCount) throws IOException {
        super(path, testsCount);
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {

    }
}
