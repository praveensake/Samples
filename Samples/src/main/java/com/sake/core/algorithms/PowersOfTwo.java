package com.sake.core.algorithms;

/*
Prints all the powers of two under a given number
 */
public class PowersOfTwo {

    public static void main(String[] args) {

        printPowersOfTwo(100);
    }

    private static int printPowersOfTwo(int x){

       if(x<1) {
           return 0;
       }
       else if (x==1){
           System.out.println(1);
           return 1;
       }else{
           int prev = printPowersOfTwo(x/2);
           int curr = prev*2;
           System.out.println(curr);
           return curr;
       }

    }
}
