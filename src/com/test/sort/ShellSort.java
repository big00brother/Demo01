package com.test.sort;

import java.util.Arrays;

public class ShellSort {

    public void shellSort2(int[] arr) {
        if(arr == null) {
            return ;
        }
        int step = arr.length / 2;
        while(step >= 1) {
            for(int i = step; i < arr.length; i++) {
                int val = arr[i];
                int j = i -step;
                while(j >= 0 && arr[j] > val) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = val;
            }
            step = step / 2;
        }
    }

    public void shellSort(int[] arr) {
        if (arr == null) {
            return ;
        }
        int step = 1;
        int limit = (arr.length - 1) / 3;
        while (step <= limit) {
            step = step * 3 + 1;
        }
        while(step >= 1) {
            for(int i = step; i < arr.length; i++) {
                int val = arr[i];
                int j = i - step;
                while(j >= 0 && arr[j] > val) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = val;
            }
            step = (step - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 1, 2, 6, 5, 8, 9, 7};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
