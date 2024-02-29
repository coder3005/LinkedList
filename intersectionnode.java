//brute force approach -O(n^2)

import java.util.LinkedList;

public class LinkedListB {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

        public static int getIntersectionNode(Node head1, Node head2) {
            Node temp1=head1;
            Node temp2=head2;
            while(temp1!=null) {
                while(temp2!=null) {
                    if(temp1.data==temp2.data) {
                        return temp1.data;
                    }
                    temp2=temp2.next;
                }
                temp2=head2;
                temp1=temp1.next;
            }
            return -1;
    }
    public static void main(String[] args) {
        Node head1=new Node(4);
        Node newNode=new Node(5);
        head1.next=newNode; //4->5
        newNode=new Node(6);
        head1.next.next=newNode; //4->5->6
        newNode=new Node(7);
        head1.next.next.next=newNode;//4->5->6->7

        Node head2=new Node(1);
        newNode=new Node(2);
        head2.next=newNode;//1->2
        newNode=new Node(3);
        head2.next.next=newNode;//1->2->3
        newNode=new Node(6);
        head2.next.next.next=head1.next.next;//1->2->3->6
        
        int mergingPoint=getIntersectionNode(head1,head2);
        if(mergingPoint==-1) {
            System.out.println("They are not merging");
        }
        else {
            System.out.println("They are merging");
            System.out.println(getIntersectionNode(head1,head2));
        }
    }
}
