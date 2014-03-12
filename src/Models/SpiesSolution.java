package Models;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class SpiesSolution {
    private static Graph graph;
    private static boolean[][] languageMatrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpiesSolution solution = new SpiesSolution();
        if(solution.solve(scanner)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    public boolean solve(Scanner scanner){
        int n = scanner.nextInt();
        graph = new Graph(n);
        int k = scanner.nextInt();
        createLanguageMatrix(scanner, n, k);
        createGraph();
        int start = 0;
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, start);
        bfs.run();
        return allVertexesVisited(bfs);
    }

    private boolean allVertexesVisited(BreadthFirstSearch bfs) {
        for(int i = 0; i < bfs.getNumberOfVertexes(); ++i){
            if(!bfs.visited(i)){
                return false;
            }
        }
        return true;
    }


    private void createGraph() {
        for(int language = 0; language < languageMatrix[0].length; ++language){
            for(int spy = 0; spy < languageMatrix.length; ++spy){
                if(speaksLanguage(language, spy)){
                    connectToAllOtherSpeakers(language, spy);
                }
            }
        }
    }

    private void connectToAllOtherSpeakers(int language, int spy) {
        for(int otherSpy = spy + 1; otherSpy < languageMatrix.length; ++otherSpy){
            if(speaksLanguage(language, otherSpy)){
                graph.connect(spy, otherSpy);
                graph.connect(otherSpy, spy);
            }
        }
    }

    private boolean speaksLanguage(int language, int spy) {
        return languageMatrix[spy][language];
    }

    private void createLanguageMatrix(Scanner scanner, int n, int k) {
        languageMatrix = new boolean[n][k];
        for(int i = 0; i < n; ++i){
            int numberOfLangs = scanner.nextInt();
            for(int j = 0; j < numberOfLangs; ++j){
                int language = scanner.nextInt();
                languageMatrix[i][language] = true;
            }
        }
    }
}
