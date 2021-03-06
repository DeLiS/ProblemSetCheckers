package Models;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Friendship {
    enum QueryType {Unite, CheckFriendship}

    public static final String WRONG_INPUT = "Wrong input";
    private static final int YES_CODE = 1;
    private static final int NO_CODE = 0;


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
        QueryType type = getTypeOfRequest(firstChild, secondChild);
        switch (type){
            case Unite:
                --firstChild; // 1.. N -> 0..(N-1)
                --secondChild;
                makeFriends(firstChild, secondChild);
                break;
            case CheckFriendship:
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

    private QueryType getTypeOfRequest(int firstChild, int secondChild) throws IllegalArgumentException {
        if(firstChild < 0 && secondChild < 0){
            return QueryType.CheckFriendship;
        }
        if(firstChild > 0 && secondChild > 0){
            return QueryType.Unite;
        }
        throw new IllegalArgumentException("Wrong signs");
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
