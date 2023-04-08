package com.test.sort;

public class RadixSort2 {
    //获取数组中数字的最大位数（比如-1107最大，它的最大位是千位，位数为4）
    public int getMaxDigit(int[] arr) {
        int absMax = Math.abs(arr[0]);
        for(int val : arr) {
            int absVal = Math.abs(val);
            if(absVal > absMax) {
                absMax = absVal;
            }
        }
        int digit = 0;
        while(absMax != 0) {
            digit++;
            absMax /= 10;
        }
        return digit;
    }

    public void radixSort(int[] arr) //d表示最大的数有多少位
    {
        if(arr == null || arr.length < 2) {
            return ;
        }
        int d = getMaxDigit(arr);
        int index = 0; //arr数组索引位置
        int n = 1; //位数（1是个位数，10是十位数，依此类推）
        int m = 1; //控制键值排序依据在哪一位
        //数组的第一维表示可能的余数 -9 ~ 9，temp数组代表在当前位数下所有数字从小到大的排序，可以将每一维度理解为一个桶
        int[][] temp = new int[19][arr.length];
        int[] order = new int[19]; //数组order[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < arr.length; i++)
            {
                int lsd = ((arr[i] / n) % 10) + 9;
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            for(int i = 0; i < 19; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        arr[index] = temp[i][j];
                        index++;
                    }
                order[i] = 0;
            }
            n *= 10;
            index = 0;
            m++;
        }
    }
    public static void main(String[] args)
    {
        int[] data = new int[] {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100, -2, - 3, -12, -22, -45, -102, -1223, -4567, 234};
        RadixSort2 radixSort = new RadixSort2();
        radixSort.radixSort(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
}