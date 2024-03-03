package com.example.junit5practice.java;

public class Calculator1 {
    public int sum(int a, int b){
        if (a < 0 || b < 0) {
            throw new RuntimeException();
        }
        return a + b;
    }
}
