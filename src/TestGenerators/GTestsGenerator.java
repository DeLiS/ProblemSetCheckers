package TestGenerators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

/**
 * Created by Denis on 13.03.14.
 */
public class GTestsGenerator extends AbstractTestGenerator {
    public static final int MAKE_FRIENDS_COMMAND = 10;
    public static final int QUERY_FRIENDSHIP = 20;
    public static final int QUERY_SIZE = 2;
    private final int maxNumberOfChildren;
    private final int maxNumberOfQueries;
    private final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws Exception {
        String path = args[0];
        int testsCount = Integer.parseInt(args[1]);
        int maxNumberOfChildren = Integer.parseInt(args[2]);
        int maxNumberOfQueries = Integer.parseInt(args[3]);
        GTestsGenerator generator = new GTestsGenerator(path, testsCount, maxNumberOfChildren, maxNumberOfQueries);
        generator.generate();

    }

    public GTestsGenerator(String path, int testsCount, int maxNumberOfChildren, int maxNumberOfQueries) throws IOException {
        super(path, testsCount);
        this.maxNumberOfChildren = maxNumberOfChildren;
        this.maxNumberOfQueries = maxNumberOfQueries;
    }

    @Override
    protected void createInput(PrintWriter inputWriter) throws Exception {

        int numberOfChildren = random.nextInt(maxNumberOfChildren-1) + 2;
        int numberOfQueries = random.nextInt(maxNumberOfQueries) + 1;
        int[][] queries = new int[numberOfQueries][QUERY_SIZE];
        createQueries(queries, numberOfChildren);
        String input = InputOutputFormatter.queriesToGInput(numberOfChildren, numberOfQueries, queries);
        inputWriter.print(input);
        inputWriter.flush();
        inputWriter.close();
    }

    private void createQueries(int[][] queries, int numberOfChildren) {
        List<int[]> pairs = PairGenerator.createPairsList(numberOfChildren);

        for(int i = 0; i < queries.length; ++i){
            createQuery(queries[i], numberOfChildren, pairs);
        }
    }

    private void createQuery(int[] query, int numberOfChildren, List<int[]> pairs) {


        if(pairs.size() > 0 && random.nextBoolean()){
            int[] pair = PairGenerator.getNextPair(random, pairs);
            query[0] = pair[0];
            query[1] = pair[1];
        }else{
            query[0] = random.nextInt(numberOfChildren);
            do{
                query[1] = random.nextInt(numberOfChildren);
            }while(query[1] == query[2]);
            changeSignsForCodingQuery(query);
        }
    }

    private void changeSignsForCodingQuery(int[] query) {
        query[0] = -query[0];
        query[1] = -query[1];
    }
}
