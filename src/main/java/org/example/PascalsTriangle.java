package org.example;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * <p>Given an index k, return the kth row of the Pascal's triangle.
 *
 * <p>For example, given k = 3, Return [1,3,3,1].
 *
 * <p>Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().getRowCombinatoria(4));
    }

    public List<Integer> getRow(int rowIndex){
         int k = rowIndex;
        if(k==0) return Arrays.asList(1);
        if(k==1) return Arrays.asList(1,1);
        if(k==2) return Arrays.asList(1,2,1);

        List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 1));

        k = k - 2;
        int p;
        while (k-- > 0) {
            p = 1;
            for (int i = 1; i < result.size(); i++){
                 int c = result.get(i);
                 result.set(i,p+ c);
                 p=c;
            }
            result.add(1);


        }
        result.set(0,1);

        return result;

    }


    public List<Integer> getRowCombinatoria(int rowIndex ){
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        long current = 1;
        result.add((int) current);
        for (int i =1;i <= rowIndex;i++){
            current = current * (rowIndex - i + 1) / i;
           result.add((int)current);
        }
        return result;
    }
}
