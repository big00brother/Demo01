package com.test;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueTest {

    //按照堆的结构来存储数据
    private List<PriorityQueues> list = new ArrayList<>();

    public PriorityQueues pop() {
        if(list.isEmpty()) {
            return null;
        }
        //这个需要深拷贝
        PriorityQueues popVal = list.get(0);
        if(list.size() == 1) {
            list.remove(0);
            return popVal;
        }
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        rebuildQueues(0);
        return popVal;
    }

    public void push(PriorityQueues queuesVal) {
        if(list.isEmpty()) {
            list.add(queuesVal);
            return ;
        }

        list.add(queuesVal);
        swap(0, list.size() - 1);

        //重新调整堆的结构
        rebuildQueues(0);
    }

    public void rebuildQueues(int start) {
        int left = start * 2 + 1;
        int right = start * 2 + 2;

        PriorityQueues startVal = list.get(start);
        PriorityQueues maxPriorityVal = startVal;
        int maxIndex = start;
        if(left < list.size() && list.get(left) != null) {
            PriorityQueues leftVal = list.get(left);
            //优先级小的往下移动，相等的情况下后进的往下移动
            if(leftVal.getPriority() > maxPriorityVal.getPriority()) {
                maxPriorityVal = leftVal;
                maxIndex = left;
            }

        }
        if(right < list.size() && list.get(right) != null) {
            PriorityQueues rightVal = list.get(right);
            if(rightVal.getPriority() > maxPriorityVal.getPriority()) {
                maxPriorityVal = rightVal;
                maxIndex = right;
            }
        }
        if(maxPriorityVal == startVal) {
            return ;
        }
        swap(start, maxIndex);
        rebuildQueues(maxIndex);
    }

    //交换元素位置
    public void swap(int a, int b) {
        PriorityQueues tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }
}


class PriorityQueues {
    //优先级
    private Integer priority;

    public PriorityQueues(Integer priority, Integer index, String value) {
        this.priority = priority;
        this.index = index;
        this.value = value;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //进来的第几个数据
    private Integer index;
    //存储的数据
    private String value;
}