package com.tutorial;

import java.util.*;

public class WordLadder {

    Map<String, List<String>> al = new HashMap<>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String w: wordList) {
            List<String> l = findList(w, wordList);
            al.put(w, l);
        }
        al.put(beginWord, findList(beginWord, wordList));
        Queue<String> q = new LinkedList<>();
        int count = 1;
        boolean found = false;
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int i = 0; i< size; i++) {
                String w = q.poll();
                visited.add(w);
                for(String nw: al.get(w)) {
                    if(nw.equals(endWord)) {
                        found = true;
                        break;
                    }
                    if(!visited.contains(nw)) {
                        q.add(nw);
                    }
                }
                if(found) break;
            }
            if(found) break;
        }
        return found ? count: 0;
    }

    private List<String> findList(String w, List<String> wordList) {
        List<String> a = new ArrayList<>();
        for(String word: wordList) {
            if(diff(w, word) && !w.equals(word)) {
                a.add(word);
            }
        }
        return a;
    }
    private boolean diff(String w1, String w2) {
        int count = 0;
        int i = 0;
        while(i < w1.length()) {
            if(w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
            i++;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("hot");
        arrayList.add("dot");
        arrayList.add("dog");
        arrayList.add("lot");
        arrayList.add("log");
        arrayList.add("cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", arrayList));
    }
}
