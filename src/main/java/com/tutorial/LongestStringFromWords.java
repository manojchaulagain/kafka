package com.tutorial;

import java.util.HashMap;
import java.util.Map;

public class LongestStringFromWords {
    public static void main(String[] args) {
        Trie t = new Trie();

        t.add("a");
        t.add("banana");
        t.add("app");
        t.add("ap");
        t.add("appl");
        t.add("apply");
        System.out.println(t.getNode().children.size());
        System.out.println(t.findLongest());
    }

    static class TrieNode {
        public String prefix;
        public char c;
        public boolean isWord;
        public Map<Character, TrieNode> children = new HashMap<>();

        TrieNode(char c, String prefix) {
            this.prefix = prefix;
            this.c = c;
        }
    }

    static class Trie {
        TrieNode node;
        public Trie() {
            node = new TrieNode('*', "");
        }

        public TrieNode getNode() {
            return node;
        }

        public void add(String s) {
            TrieNode curr = node;
            for(int i = 0; i < s.length(); i++) {
                if(curr.children.containsKey(s.charAt(i))) {
                    curr = curr.children.get(s.charAt(i));
                } else {
                    curr.children.put(s.charAt(i), new TrieNode(s.charAt(i), s.substring(0, i + 1)));
                    curr = curr.children.get(s.charAt(i));
                }
                if(i == s.length() -1) {
                    curr.isWord = true;
                }
            }
        }

        public String findLongest(){
             return findLongest(node, "");

        }

        public String findLongest(TrieNode node, String val) {
            for(TrieNode n: node.children.values()) {
                if(n.isWord) {
                    val = n.prefix.length() > val.length() ? n.prefix: val;
                    String v = findLongest(n, val);

                    val = v.length() > val.length() ? v: val;
                }
            }
            return val;
        }

    }

}
