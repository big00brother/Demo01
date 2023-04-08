package com.test;

public class Heap {

    //堆元素数量
    private int size;

    //堆数组
    private int[] arr;

    public Heap(int size, int[] arr) {
        this.size = size;
        this.arr = arr;
        buildMaxHeap();
    }

    //构造最大堆
    private void buildMaxHeap() {
        if (size <= 1) {
            return ;
        }
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustMaxHeapFromTop(i);
        }
    }

    //堆排序，使arr数组的最后结构变为从小到大
    private void heapSort() {
        int count = size;
        for(int i = 0; i < count; i++) {
            //每次循环执行一次删除操作
            remove();
        }
    }

    //删除操作，将最大堆顶部的元素和最后一个索引位置的元素进行交换，同时最大堆的元素数量减1，然后调整新的最大堆结构
    private int remove() {
        swap(0, size - 1);
        size--;
        adjustMaxHeapFromTop(0);
        return arr[size];
    }

    //从当前索引调整最大堆结构，使当前索引为root的堆为最大堆
    private void adjustMaxHeapFromTop(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if(left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != index) {
            swap(largest, index);
            adjustMaxHeapFromTop(largest);
        }
    }

    //添加元素
    public void add(int num) {
        //数组空间不够则扩容
        if(size == arr.length) {
            int[] copyArr = new int[size + 1];
            copyArray(copyArr, arr);
            arr = copyArr;
        }
        arr[size] = num;
        size++;
        adjustMaxHeapFromBottom(size - 1);
    }

    //从当前位置往上调整最大堆结构
    public void adjustMaxHeapFromBottom(int index) {
        while(index != 0) {
            int parent = -1;
            if(index % 2 == 1) {
                parent = (index - 1) / 2;
            } else {
                parent = (index - 2) / 2;
            }
            if(arr[parent] < arr[index]) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    //拷贝数组
    public void copyArray(int[] target, int[] source) {
        for(int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    //交换数组元素位置
    public void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //打印堆排序后的数组
    public void printHeapSortArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 5, 4, 1};
        Heap heap = new Heap(arr.length, arr);
        heap.remove();
        heap.add(6);
        heap.heapSort();
        heap.printHeapSortArr();
    }
}
