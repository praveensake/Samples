package com.sake.core.algorithms;

/*
Prints all the fibonacci numbers from o to 10
 */
public class FibonacciNumbers {

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            System.out.println(i + " : "+ fib(i));
        }
    }

    private static int fib(int n){
        if(n<=0){
            return 0;
        }
        else if (n==1){
            return 1;
        }
        else{
            int val = fib(n-1)+fib(n-2);
            return val;
        }
    }

}


