package com.ask.log.algo;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(50, new long[51]));
    }

    private long fib(int input,long[] holder) {
        if (input <=2) {
            return 1;
        }
        if (holder[input] != 0) {
            return holder[input];
        }
        holder[input-2] = fib(input-2, holder);
        holder[input-1] = fib(input-1, holder);
        holder[input] = holder[input-2] + holder[input-1];
        return holder[input];
    }
}
