package com.tutorial;

import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        new NextGreater().findNextGreater(new int[]{
                5, 4, 9,8,7, 6
        });
    }
    public void findNextGreater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for(int i: arr) {
            if(s.isEmpty()) {
                s.push(i);
            } else {
                while(!s.isEmpty() && s.peek() > i) {
                    System.out.println(s.pop() + " - > " + i);
                }
                s.push(i);
            }
        }
        while(!s.isEmpty()) {
            System.out.println(s.pop() + " --> no");
        }
    }
}
