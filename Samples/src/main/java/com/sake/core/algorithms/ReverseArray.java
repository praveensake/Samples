package com.sake.core.algorithms;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        char [] arr = {'a','b','c','d','e'};

        for (int i=0;i<arr.length/2;i++){
            char last = arr[arr.length-i-1];
            char temp = arr[i];
            arr[i] = last;
            arr[arr.length-i-1] = temp;
        }

        System.out.println(arr);
    }
}
