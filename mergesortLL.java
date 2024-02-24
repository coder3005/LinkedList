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

    private Node getMid(Node head) {
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL=new Node(-1); //dummy node
        Node temp=mergedLL;

        while(head1!=null && head2!=null) {
            if(head1.data<=head2.data) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null) {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    
    public Node mergeSort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left & right MS
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    public static void print() { // O(n)
        if (head == null) { // if we remove this is if operation then null will print
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
        LinkedList ll=new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head=ll.mergeSort(ll.head);
        ll.print();
        
    }
} 
