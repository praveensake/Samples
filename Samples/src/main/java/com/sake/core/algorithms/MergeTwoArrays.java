package com.sake.core.algorithms;


import java.util.Arrays;

/**
 * Created by sakez on 07/08/17
 * This class merges two arrays of integers into one
 */
public class MergeTwoArrays {

    public static void main(String[] args) {

        int[] a = {6,7,8};
        int[] b = new int[6];
        b[0] = 3;
        b[1] = 4;
        b[2] = 5;

        mergeArray1(a, b, 3);
    }

    static void mergeArray1(int[] a, int[] b, int M){

        long[] mergedArray = new long[2*M];
        int i = 0, j = 0, k = 0;
        long tmp;
        while (i < M && j < M) {
            tmp = a[i] < b[j] ? a[i++] : b[j++];
            for ( ; i < M && a[i] == tmp; i++);
            for ( ; j < M && b[j] == tmp; j++);
            mergedArray[k++] = tmp;
        }
        while (i < M) {
            tmp = a[i++];
            for ( ; i < M && a[i] == tmp; i++);
            mergedArray[k++] = tmp;
        }
        while (j < M) {
            tmp = b[j++];
            for ( ; j < M && b[j] == tmp; j++);
            mergedArray[k++] = tmp;
        }
        long[] l  = Arrays.copyOf(mergedArray, k);

        int p=0;
        while(p<l.length && l[p]!=0) {
            System.out.println(l[p]);
            p++;
        }

    }


}
