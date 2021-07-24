package com.tutorial;

public class Reverse {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node run(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node r = reverse(slow.next);
        slow.next = null;
        Node l = head;
        Node newHead = new Node(-1, null);
        Node dummy = newHead;
        while(r != null && l != null) {
            dummy.next = l;
            l = l.next;
            dummy = dummy.next;
            dummy.next = r;
            dummy = dummy.next;
            r = r.next;
            dummy.next = null;
        }
        if(r != null) {
            dummy.next = r;
        }
        if(l != null) {
            dummy.next = l;
        }
        return newHead.next;
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
        Reverse r = new Reverse();
        r.print(n);
        Node head = r.run(n);
        r.print(head);

    }
}
