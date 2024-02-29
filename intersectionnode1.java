//optimized code - O(n+m)

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
            while(temp1!=temp2) {
                temp1=temp1.next;
                temp2=temp2.next;

                if(temp1==null && temp2==null) {
                    return -1;
                }

                if(temp1==null) {
                    temp1=head2;
                }
                if(temp2==null) {
                    temp2=head1;
                }
            }
            return temp1.data;
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
