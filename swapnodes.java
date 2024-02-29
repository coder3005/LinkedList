/* We have a linked list and two keys in it, swap nodes for two given keys. Nodes should be
 swapped by changing links. Swapping data of nodes may be expensive in many situations when
 data contains many fields. It may be assumed that all keys in the linked list are distinct */

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

    public static void swapNodes(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and CurrY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null) return;

        // If x is not head of linked list
        if (prevX != null) prevX.next = currY;
        else head = currY; // Make y the new head

        // If y is not head of linked list
        if (prevY != null) prevY.next = currX;
        else head = currX; // Make x the new head

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
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
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        swapNodes(2,4);
        ll.print();
    }
}
