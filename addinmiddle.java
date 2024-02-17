public class LinkedList {
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

    public void addLast(int data) { // O(1)
        // step1- create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2- tail.next=newNode
        tail.next = newNode;

        // step3- tail=newNode
        tail = newNode;
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
    public void add(int idx, int data) {
        if(idx==0) {
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        Node temp=head;
        int i=0;
        while(i<idx-1) {
            temp=temp.next;
            i++;
        }
        //i=idx-1 -> prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2,9);

        ll.print();
    }
}
