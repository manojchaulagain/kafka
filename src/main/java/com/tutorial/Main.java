package com.tutorial;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  void reverse(int[] arr, int l, int r) {
    while(l < r) {
      int temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;
      l++;
      r--;
    }
  }

  int minOperations(int[] arr) {
    // Write your code here
    int result = 0;
    boolean add = true;
    for(int i = 1; i < arr.length; i++) {
      if(arr[i - 1] < arr[i]) {
        if(add) {
          result++;
          add = false;
        }
      } else {
        add = true;
      }
    }
    return result;
    
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {

    int n_1 = 5;
    int[] arr_1 = {1, 2, 5, 4, 3};
    int expected_1 = 1;
    int output_1 = minOperations(arr_1);
    check(expected_1, output_1);

    int n_2 = 3;
    int[] arr_2 = {3, 1, 2};
    int expected_2 = 2;
    int output_2 = minOperations(arr_2);
    check(expected_2, output_2);
    
    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new Main().run();
  }
}