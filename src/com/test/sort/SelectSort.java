package com.test.sort;

import java.util.Arrays;

public class SelectSort {

    public void selectSort(int[] arr) {
        if(arr == null) {
            return ;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            //min代表当前未排序数组中最小值索引
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                swap(min, i, arr);
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
        int[] arr = new int[] {3, 2, 4, 1, 6, 7, 5, 8};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
