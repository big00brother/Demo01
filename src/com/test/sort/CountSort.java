package com.test.sort;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 2, 5, 3, 7, 6, 22, 23, 15, 24, 6, 3,
                4, 5, 2, 3, 5, 12, 1, 3, 4, 2, 1,
                3, 45, 1, 1};
        CountSort countSort = new CountSort();
        // 计数排序
//        int[] ints = countSort.countSort1(arr);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + " ");
//        }
        countSort.countSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 用于获取最大值
        int max = arr[0];
        int min = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }
        // 用数组中的值减去最小值作为索引，个数作为值
        int[] newArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i] - min]++;
        }
        int index = 0;
        // 遍历并且重新覆盖该值
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i]; j++) {
                arr[index++] = i + min;
            }
        }
    }

    private int[] countSort1(int[] arr) {
        // 检测数据
        if (arr == null || arr.length == 0) {
            return arr;
        }
        // 缩短不必要的长度，获取最大和最小值
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 用数组中的值减去最小值作为索引，个数作为值
        int[] newArr = new int[(max - min + 1)];
        // 用于记录当前数据排在第几位
        int[] countArr = new int[newArr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i] - min]++;
        }
        // 统计数组，记录后面的元素等于前面的元素之和
        for (int i = 0; i < newArr.length; i++) {
            if (i == 0) {
                countArr[i] = newArr[i];
                continue;
            }
            countArr[i] = newArr[i] + countArr[i - 1];
        }
        // 最终结果
        int[] result = new int[arr.length];
        // 反向遍历
        for (int i = arr.length - 1; i >= 0; i--) {
            // 将数据放入指定的位置中,统计数组中记录的是元素排在第几位
            result[countArr[arr[i] - min] - 1] = arr[i];
            // 排列一个后，就减少一个
            countArr[arr[i] - min]--;
        }
        return result;
    }
}