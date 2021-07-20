package com.example.sortarray;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {
    public static void main(String[] args) {
        Integer[] arr = {3,12,54,6};

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < arr.length ; i++) {

            System.out.println(arr[i]);

        }
    }
}