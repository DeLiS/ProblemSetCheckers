package TestGenerators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Denis on 13.03.14.
 */
public abstract  class AbstractTestGenerator {
    private TestsFolder testsFolder;
    private int testsCount;
    public AbstractTestGenerator(String path, int testsCount) throws IOException {
        this.testsCount = testsCount;
        testsFolder = new TestsFolder(path, testsCount);
    }

    public void generate() throws Exception {
        for(int testNo = 0; testNo < testsCount; ++testNo){
            generateOneTest(testNo);
        }
    }

    protected void generateOneTest(int testNo) throws Exception {
        createInput(testsFolder.getWriterForTestInputNo(testNo));
    }

    protected abstract void createInput(PrintWriter inputWriter) throws Exception;
}
