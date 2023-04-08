package com.test;

import java.util.ArrayList;

public class QuickSortTest02 {

    //快速排序入口函数。l是数组的左边界，初始值为0；r为数组的右边界，初始值为数组长度
    public void quickSort(int l, int r, int[] arr) {
        if (l == r) {
            return ;
        }
        int[] mid = partition(l, r, arr);
        quickSort(l, mid[0], arr);
        quickSort(mid[1], r, arr);
    }

    //分割函数。l是数组的左边界，r为数组的右边界
    public int[] partition(int l, int r, int[] arr) {
        //数组最左边的数与[l, r)区间范围内的数交换位置
        int s = l + (int) (Math.random() * (r - l));
        swap(l, s, arr);
        //p为当前数组遍历指针
        int p = l;
        //val为分界值
        int val = arr[p];
        while (p < r) {
            //小于分界值的排到左边
            if(arr[p] < val) {
                swap(p, l, arr);
                l++;
                p++;
            } else if (arr[p] == val) { //等于分界值的排到中间
                p++;
            }
            //大于分界值的排到右边
            else {
                swap(p, r - 1, arr);
                r--;
            }
        }
        return new int[] {l, r};
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
        QuickSortTest02 quickSortTest = new QuickSortTest02();
        quickSortTest.getSortedArray(arr);
        for(int a : arr) {
            System.out.println(a);
        }
    }
}
