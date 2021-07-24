package com.tutorial;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        List<String> s = topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        s.forEach(System.out::println);
    }

    static class Word implements Comparable<Word> {
        int count;
        String w;
        Word(String w, int c) {
            this.w = w;
            this.count = c;
        }

        @Override
        public int compareTo(Word o) {
            if(o.count == this.count) {
                return w.compareTo(o.w);
            } else {
                return this.count - o.count;
            }
        }
    }

    public static List<String> topKFrequent(String[] nums, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String n : nums) {
            if (countMap.containsKey(n)) {
                countMap.put(n, 1 + countMap.get(n));
            } else {
                countMap.put(n, 1);
            }
        }


        PriorityQueue<Word> node = new PriorityQueue<>();

        Long l = 2L;
        l.longValue();
        
        for (String e : countMap.keySet()) {
            if(node.size() < k) {
                node.add(new Word(e, countMap.get(e)));
            } else {
                if(node.peek().count < countMap.get(e)) {
                    node.poll();
                    node.add(new Word(e, countMap.get(e)));
                }

            }
        }

        List<String> arr = new ArrayList<>();
        while(!node.isEmpty()) {
            arr.add(node.remove().w);
        }
        return arr;
    }
}
