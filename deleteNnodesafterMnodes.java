/* Traverse the linked list such that you retain M
 nodes then delete next N nodes, continue the same till end of the linked list */

public class solution {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
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

    public static Node deleteNnodesAfterM(int M, int N) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while(temp!=null) {
        for (int i = 0 ; i < M-1; i++) {
            if (temp == null)
                return null;
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            // There are not enough nodes to perform deletion
            return null;
        }        
        for (int i = 0; i < N ; i++) {  //delete
            if (temp.next == null)
                return null;
            temp.next=temp.next.next;
        }        
        temp=temp.next; 
    }
    return head;
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
        solution ll=new solution();
        // ll.addFirst(10);
        // ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        deleteNnodesAfterM(2, 2);
        ll.print();
    }
}
