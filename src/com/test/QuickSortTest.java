package com.test;

import java.util.ArrayList;

public class QuickSortTest {

    //快速排序入口函数。l是数组的左边界，初始值为0；r为数组的右边界，初始值为数组长度
    public void quickSort(int l, int r, int[] arr) {
        if (l == r) {
            return ;
        }
        int t = partition(l, r, arr);
        quickSort(l, t, arr);
        quickSort(t + 1, r, arr);
    }

    //分割函数。l是数组的左边界，r为数组的右边界
    public int partition(int l, int r, int[] arr) {
        //p为当前分界值的数组索引
        int p = l;
        while (l < r) {
            //小于等于分界值的排到左边
            if(arr[p] >= arr[l]) {
                swap(p, l, arr);
                p = l;
                l++;
            }
            //大于分界值的排到右边
            else {
                swap(l, r - 1, arr);
                r--;
            }
        }
        return l - 1;
    }

    //数组交换函数
    public void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        quickSort(0, input.length, input);
        for(int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public void getSortedArray(int[] arr) {
        int l = 0;
        int r = arr.length;
        quickSort(l, r, arr);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 6, 7, 3, 6, 7, 8, 12, 1};
        QuickSortTest quickSortTest = new QuickSortTest();
        quickSortTest.getSortedArray(arr);
        for(int a : arr) {
            System.out.println(a);
        }
    }
}


