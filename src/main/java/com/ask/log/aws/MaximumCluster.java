package com.ask.log.aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumCluster {
    public static void main(String[] args) {
        List<Integer> bootPower = Arrays.asList(2,3,4,6,7);
        List<Integer> processingPower = Arrays.asList(2,3,4,6,7);
        MaximumCluster maximumCluster = new MaximumCluster();

        System.out.println(maximumCluster.clusterPower(bootPower, processingPower, 32));
    }

    private int clusterPower(List<Integer> bootPower, List<Integer> processPower, int limit) {

        int result = 0;
        Map<String, Integer> holder = new HashMap<>();
        for (int i = processPower.size() -1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j < processPower.size(); j++) {
                Integer memoVal = holder.get((i +1) + "," + j);
                if (memoVal != null && memoVal ==0) {
                    break;
                }
                min = Math.min(min, bootPower.get(j));
                sum+= processPower.get(j);
                int length = ((j-i)+1);
                int totalPower = min + length* sum;
                if (totalPower < limit) {
                    holder.put(i + "," + j, 1);
                    result = Math.max(result, length);
                } else {
                    holder.put(i + "," + j, 0);
                    break;
                }
            }
        }
        return result;
    }
}
