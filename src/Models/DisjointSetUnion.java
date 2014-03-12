package Models;

import java.util.Random;

/**
 * Created by Denis on 12.03.14.
 */
public class DisjointSetUnion {

    private int[] dsu;
    private Random random = new Random(System.currentTimeMillis());
    public DisjointSetUnion(int n){
        dsu = new int[n];
        for(int i = 0; i < n; ++i){
            dsu[i] = i;
        }
    }

    public int getSetNumberOfElement(int element){
        if(dsu[element] == element){
            return element;
        }else{
            dsu[element] = getSetNumberOfElement(dsu[element]);
            return dsu[element];
        }
    }

    public boolean areInTheSameSet(int a, int b){
        return getSetNumberOfElement(a) == getSetNumberOfElement(b);
    }

    public void uniteSetsOf(int a, int b){
        if(random.nextBoolean()){
            int bNumber = getSetNumberOfElement(b);
            dsu[bNumber] = a;
        }else{
            int aNumber = getSetNumberOfElement(a);
            dsu[aNumber] = b;
        }

    }
}
