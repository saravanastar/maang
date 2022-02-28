package com.ask.log.ds.bitwise;

public class DifferByOneBit {

    public static void main(String[] args) {

        DifferByOneBit differByOneBit = new DifferByOneBit();
        System.out.println(differByOneBit.isDifferByOneBit(4,5));
//        System.out.println(4|2);
//        System.out.println(6|2);

    }
    private boolean isDifferByOneBit(int x, int y) {
        int z = x ^ y;
//        int sum = 0;
        if (z >> 1 > 0) {
            return false;
        }
        return true;
//        while (z > 0) {
//            sum+= z & 1;
//            z>>=1;
//            if (sum > 1) {
//                return false;
//            }
//        }
//        return true;
    }
}
