package com.test.sort;

import java.util.Arrays;

public class InsertSort {

    public void insertSort2(int[] arr) {
        if(arr == null) {
            return ;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(j, j-1, arr);
                }
            }
        }
    }

    public void insertSort(int[] arr) {
        if(arr == null) {
            return ;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                int val = arr[i];
                int low = 0;
                int height = i - 1;
                while(low <= height) {
                    int mid = (low + height) / 2;
                    if(arr[mid] > val) {
                        height = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for(int j = i; j >low; j--) {
                    arr[j] = arr[j-1];
                }
                arr[low] = val;
            }

        }
    }

    //数组交换函数
    public void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = new int[] {3, 4, 5, 2, 6, 1, 7};
        insertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
