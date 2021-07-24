package com.tutorial;

public class ReverseII {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node run(Node n, int s, int e) {
        Node slow = n;
        Node fast = n;
        for(int i = 0; i < s - 1; i++) {
            slow = slow.next;
        }

        for(int i = 0; i < e; i++) {
            fast = fast.next;
        }
        Node start = slow.next;
        slow.next = null;
        Node tail = fast.next;
        fast.next = null;
        slow.next = reverse(start);
        start.next = tail;
        return n;
    }

    public Node reverse(Node n) {
        Node prev = null;
        Node cur = n;
        while(cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public void print(Node n) {
        Node c = n;
        while(c != null) {
            if(c.next == null) {
                System.out.print(c.data);
            } else {
                System.out.print(c.data + " -> ");
            }
            c = c.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node n = new Node(3, new Node(2, new Node(5, new Node(1, new Node(4, null)))));
        ReverseII r = new ReverseII();
        r.print(n);
        Node head = r.run(n, 1, 3);
        r.print(head);

    }
}
