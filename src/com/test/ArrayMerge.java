package com.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ArrayMerge {

    public List<Integer> merge(ArrayList<ArrayList<Integer>> list) {
        List<CurNum> curNumList = new ArrayList<>();
        for(int i=0; i < list.size(); i++) {
            if(list.get(i) != null || list.get(i).size() != 0) {
                Integer num = list.get(i).get(0);
                CurNum curNum = new CurNum(i, 0, num);
                curNumList.add(curNum);
            }

        }

        List<Integer> resultList = new ArrayList<>();

        while (!curNumList.isEmpty()) {
            int value = judge(curNumList, list);
            resultList.add(value);
        }

        return resultList;

    }

    public int judge(List<CurNum> curNumList, List<ArrayList<Integer>> list) {

        //最小的数组索引
        Integer minIndex = -1;
        for(int i=0; i < curNumList.size(); i++) {

            CurNum curNum = curNumList.get(i);

            if(minIndex == -1) {
                minIndex = i;
            } else {
                if(curNum.value < curNumList.get(minIndex).value) {
                    minIndex = i;
                }
            }
        }
        CurNum minCurNum = curNumList.get(minIndex);
        if(minCurNum.index != list.get(minIndex).size() - 1) {

            curNumList.set(minIndex, new CurNum(minCurNum.listIndex, minCurNum.index +1, list.get(minCurNum.listIndex).get(minCurNum.index +1)));
        } else {
            curNumList.remove((int) minIndex);
        }
        return minCurNum.value;
    }

    public static void main(String[] args) {
        ArrayMerge arrayMerge = new ArrayMerge();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(7);
        list2.add(9);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(6);
        list3.add(8);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<Integer> resultList = arrayMerge.merge(lists);
        System.out.println(resultList);
    }
}

class CurNum {
    //第几个数组
    public Integer listIndex;
    //数组索引
    public Integer index;

    public Integer value;

    public CurNum(Integer listIndex, Integer index, Integer value) {
        this.listIndex = listIndex;
        this.index = index;
        this.value = value;
    }
}
