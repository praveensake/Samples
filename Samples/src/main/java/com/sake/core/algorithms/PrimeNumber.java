package com.sake.core.algorithms;

public class PrimeNumber {

    public static void main(String[] args) {

        int x = 28;

        System.out.println("IsPrime: "+isPrime(x));
    }

    private static boolean isPrime(int n){

        if(n<=0){
            return false;
        }
        else if (n > 2) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
