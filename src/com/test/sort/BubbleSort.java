package com.test.sort;

import java.util.Arrays;

public class BubbleSort {

    //冒泡排序
    public void bubbleSort(int[] arr) {
        if(arr == null) {
            return ;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            //标记每一轮是否交换过数字
            boolean swapFlag = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(j, j+1, arr);
                    swapFlag = true;
                }
            }
            //这一轮没有交换过，说明数组已经有序了，故跳出循环
            if(!swapFlag) {
                break;
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
        int[] arr = new int[] {3, 4, 1, 2, 7, 5, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
