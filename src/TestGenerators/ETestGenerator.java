package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class ETestGenerator extends AbstractTestGenerator {
    private final int maxNumberOfSpies;
    private final int maxNumberOfLanguages;
    private final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxNumberOfSpies = Integer.parseInt(args[2]);
        int maxNumberOfLanguages = Integer.parseInt(args[3]);
        ETestGenerator generator = new ETestGenerator(path, testsCount, maxNumberOfSpies, maxNumberOfLanguages);
        generator.generate();

    }

    public ETestGenerator(String path, int testsCount, int maxNumberOfSpies, int maxNumberOfLanguages) throws IOException {
        super(path, testsCount);
        this.maxNumberOfSpies = maxNumberOfSpies;
        this.maxNumberOfLanguages = maxNumberOfLanguages;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {
        int k = random.nextInt(maxNumberOfSpies) + 1;
        int m = random.nextInt(maxNumberOfLanguages) + 1;
        List<List<Integer>> languages = new LinkedList<List<Integer>>();
        createLanguages(languages, k, m);
        writeInput(inputWriter, k, m, languages);

    }

    private void writeInput(PrintWriter inputWriter, int k, int m, List<List<Integer>> languages) {
        String input = InputOutputFormatter.languagesToEInput(k, m, languages);
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }

    private void createLanguages(List<List<Integer>> languages, int k, int m) {
        for(int currentSpy = 0; currentSpy < k; ++currentSpy){
            int curSpyNumberOfLanguages = random.nextInt(m) + 1; // [1, m]
            languages.add( getListOfRandomNumbers(curSpyNumberOfLanguages, m));
        }
    }

    private List<Integer> getListOfRandomNumbers(int curSpyNumberOfLanguages, int m) {
        List<Integer> result = new ArrayList<Integer>(curSpyNumberOfLanguages);
        for(int i = 0; i < m; ++i){
            result.add(i);
        }
        int toRemove = (m - (curSpyNumberOfLanguages));

        for(int j = 0; j < toRemove; ++j){
            int index = random.nextInt(result.size());
            result.set(index, result.get(result.size() - 1));
            result.remove(result.size() - 1);
        }
        return result;
    }
}
