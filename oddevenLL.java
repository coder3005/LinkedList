/* We have a Linked List of integers, write a function to modify the linked list such that all even
numbers appear before all the odd numbers in the modified linked list. Also, keep the order of
even and odd numbers same */

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

    public void addFirst(int data) { // O(1)
        // step1=create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2- newNode next=head
        newNode.next = head; // link

        // step3- head=newNode
        head = newNode;
    }

    public static void modifyLinkedList() {
        if (head == null || head.next == null)
            return; // No need to modify if the list is empty or has only one node

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node curr = head;

        // Separate even and odd nodes
        while (curr != null) {
            if (curr.data % 2 == 0) { // Even number
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else { // Odd number
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }

        // Concatenate even list with odd list
        if (evenHead != null) {
            head = evenHead;
            evenTail.next = oddHead;
        } else {
            head = oddHead;
        }

        // Set the next of oddTail to null to terminate the list
        if (oddTail != null)
            oddTail.next = null;
    }


    public void print() { //O(n)
        if (head == null) { //if we remove this is if operation then null will print
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedListB ll=new LinkedListB();
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        modifyLinkedList();
        ll.print();
    }
}
