package com.ask.log.algo;

public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.primeNumber(5);
    }
    
    private void primeNumber(int total) {
        int count = 0;
        int num =3;
        while (count < total) {
            boolean isPrime = isPrime(num);
            if (isPrime) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }

    private boolean isPrime(int number) {
        int check = number;
        if (check > 9) {
            check = 9;
        }
        for (int i = 2; i < check; i++) {
            if (number % i ==0) {
                return false;
            }
        }
        return true;
    }
}
