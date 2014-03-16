package Models;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Friendship {

    public static final String WRONG_INPUT = "Wrong input";
    private static final int YES_CODE = 1;
    private static final int NO_CODE = 0;
    private final int UNITE_CODE = 10;
    private final int QUERY_CODE = 20;

    private final DisjointSetUnion dsu;

    public List<Integer> getAnswers() {
        return answers;
    }

    private final List<Integer> answers = new LinkedList<Integer>();

    public Friendship(Scanner input) throws Exception {
        int numberOfChildren = input.nextInt();
        int numberOfQueries = input.nextInt();

        dsu = new DisjointSetUnion(numberOfChildren);
        handleQueries(input, numberOfQueries);
    }

    private void handleQueries(Scanner input, int numberOfQueries) throws Exception {
        for(int i = 0; i < numberOfQueries; ++i){
            handleQuery(input);
        }
    }

    private void handleQuery(Scanner input) throws Exception {
        int firstChild = input.nextInt();
        int secondChild = input.nextInt();
        int type = getTypeOfRequest(firstChild, secondChild);
        switch (type){
            case UNITE_CODE:
                makeFriends(firstChild, secondChild);
                break;
            case QUERY_CODE:
                firstChild = fromNegativeChildNumberToPositiveZeroBasedIndex(firstChild);
                secondChild = fromNegativeChildNumberToPositiveZeroBasedIndex(secondChild);
                checkFriendship(firstChild, secondChild);
                break;
            default:
                throw new Exception(WRONG_INPUT);
        }
    }

    private int fromNegativeChildNumberToPositiveZeroBasedIndex(int firstChild) {
        firstChild = -firstChild;
        --firstChild;
        return firstChild;
    }

    private int getTypeOfRequest(int firstChild, int secondChild) {
        if(firstChild < 0){
            return QUERY_CODE;
        }else{
            return UNITE_CODE;
        }
    }

    private void checkFriendship(int firstChild, int secondChild) {
        boolean areFriends = dsu.areInTheSameSet(firstChild, secondChild);
        if(areFriends){
            answers.add(YES_CODE);
        }else{
            answers.add(NO_CODE);
        }
    }

    private void makeFriends(int firstChild, int secondChild) {
        dsu.uniteSetsOf(firstChild, secondChild);
    }
}
