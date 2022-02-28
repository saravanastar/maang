package com.ask.log.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle  pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            result.add(Collections.singletonList(1));
        }
        if (numRows > 1) {
            result.add(Arrays.asList(1, 1));
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }
}
