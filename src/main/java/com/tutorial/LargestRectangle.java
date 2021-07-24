package com.tutorial;

import java.util.Stack;

public class LargestRectangle {
    static class Node {
        int height;
        int index;

        Node(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangle().largestRectangleArea(new int[]{
                2, 1, 5, 6, 2, 3
        }));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();
        int maxArea = 0;
        for (int curIndex = 0; curIndex < heights.length; curIndex++) {
            if (stack.isEmpty()) {
                stack.push(new Node(heights[curIndex], curIndex));
                maxArea = Math.max(maxArea, heights[curIndex]);
            } else {
                if (stack.peek().height <= heights[curIndex]) {
                    stack.push(new Node(heights[curIndex], curIndex));
                } else {
                    Node poppedNode = null;
                    while (!stack.isEmpty() && stack.peek().height > heights[curIndex]) {
                        poppedNode = stack.pop();
                        maxArea = Math.max(maxArea, poppedNode.height * (curIndex - poppedNode.index));
                    }
                    if (poppedNode != null) {
                        stack.push(new Node(heights[curIndex], poppedNode.index));
                    } else {
                        stack.push(new Node(heights[curIndex], curIndex));
                        maxArea = Math.max(maxArea, heights[curIndex]);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            Node nodeAtEnd = stack.pop();
            maxArea = Math.max(maxArea, nodeAtEnd.height * (heights.length - nodeAtEnd.index));
        }
        return maxArea;
    }
}
