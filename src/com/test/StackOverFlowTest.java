package com.test;

public class StackOverFlowTest {

    public static void main(String[] args) {
        StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();
        stackOverFlowTest.dfs(0);
    }

    public void dfs(int n) {
        int[] a = new int[10000000];
        System.out.println(n);
        if(n == 100) {
            return ;
        }
        dfs(n + 1);
    }
}
