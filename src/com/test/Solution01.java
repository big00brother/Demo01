package com.test;

public class Solution01 {
    public void mergeSort(int[] array, int left, int right) {
        // 找分割点
        int mid = left + (right - left) / 2;
        if (left < right) {
            // 合并左子数组
            mergeSort(array, left, mid);
            // 合并右子数组
            mergeSort(array, mid + 1, right);
            // 合并数组
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组，长度为此时两个子数组加起来的长度
        int[] arr = new int[right - left + 1];
        // 临时数组的下标起点
        int c = 0;
        // 保存在原数组的起点下标值
        int s = left;
        // 左子数组的起始指针
        int l = left;
        // 右子数组的起始指针
        int r = mid + 1;
        while (l <= mid && r <= right) {
            // 当左子数组的当前元素小的时候
            if (array[l] <= array[r]) {
                // 放入临时数组
                arr[c] = array[l];
                // 临时数组下标+1
                c++;
                // 左子数组指针右移
                l++;
            } else { // 否则
                // 放入临时数组
                arr[c] = array[r];

                // 临时数组+1
                c++;
                // 右子数组的指针右移
                r++;
            }
        }
        // 左子数组还有元素时，全部放入临时数组
        while (l <= mid)
            arr[c++] = array[l++];
        // 右子数组还有元素时，全部放入临时数组
        while (r <= right)
            arr[c++] = array[r++];
        // 将临时数组中的元素放入到原数组的指定位置
        for (int num : arr) {
            array[s++] = num;
        }
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        int[] arr = new int[]{3, 1, 6, 8, -1, 7, 4, 10, 8};
        solution.mergeSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }
}
