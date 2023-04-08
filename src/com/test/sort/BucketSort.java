package com.test.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    //arr为传入数组，buckNums为桶的数量
    public void bucketSort(int[] arr, int buckNums) {
        if(arr == null || arr.length <= 1) {
            return ;
        }
        List<List<Integer>> list = new ArrayList<>(buckNums);
        for(int i = 0 ; i < buckNums; i++) {
            list.add(new ArrayList<>());
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int val : arr) {
            if(val > maxValue) {
                maxValue = val;
            }
            if(val < minValue) {
                minValue = val;
            }
        }
        for(int val : arr) {
            int index = getBucketIndex(val, minValue, maxValue, buckNums);
            list.get(index).add(val);
        }
        int currentIndex = 0;
        for(List<Integer> sublist : list) {
            //对每个桶中的数据进行排序
            Collections.sort(sublist);
            for(int val : sublist) {
                arr[currentIndex++] = val;
            }
        }

    }

    //获得存储桶索引
    public int getBucketIndex(int val, int minValue, int maxValue, int buckNums) {
        return (val - minValue) * (buckNums - 1) / (maxValue - minValue);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 7, 1, 2, 6, 9, 4, 5, 8};
        int buckNums = 4;
        BucketSort bucketSort = new BucketSort();
        bucketSort.bucketSort(arr, buckNums);
        System.out.println(Arrays.toString(arr));
    }
}
