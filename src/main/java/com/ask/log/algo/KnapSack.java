package com.ask.log.algo;

public class KnapSack {

    public static void main(String[] args) {
        int[] value = new int[]{1,4,5,7};
        int[] weight = new int[]{1,3,4,5};
        KnapSack knapSack = new KnapSack();
        System.out.println(knapSack.knapSackRecusion(weight, value, 7, value.length-1));
        System.out.println(knapSack.knapSackDP(weight, value, 7));
    }


    public int knapSackRecusion(int[] wt, int[] value, int weightLimit, int currentIndex) {
        if (weightLimit == 0) return 0;
        if (currentIndex == 0) return 0;

        if (wt[currentIndex] > weightLimit)
            return knapSackRecusion(wt, value, weightLimit, currentIndex-1);

        return Math.max(value[currentIndex] + knapSackRecusion(wt, value, weightLimit - wt[currentIndex], currentIndex-1),
                knapSackRecusion(wt, value, weightLimit, currentIndex-1));
    }

    public int knapSackDP(int[] wt, int[] value, int weightLimit) {
        int[][] holder = new int[value.length+1][weightLimit+1];
        for (int row = 0; row < holder.length; row++) {
            for (int column = 0; column < holder[0].length; column++) {
                if(row == 0 || column == 0) holder[row][column] = 0;
                else if (wt[row-1] <= column)
                    holder[row][column] = Math.max(value[row-1] + holder[row-1][column-wt[row-1]], holder[row-1][column]);
                else
                    holder[row][column] = holder[row-1][column];
                
            }
        }
        return holder[value.length][weightLimit];
    }
}
