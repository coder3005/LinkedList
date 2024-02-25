public class circular {
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
    public static int size;

    public void addFirst(int data) { // O(1)
        // step1=create new node
        Node newNode = new Node(data);
        size++;
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
        size++;
        if (head == null) {
            head = tail = newNode;
            tail.next=head;
            return;
        }
        // step2- tail.next=newNode
        tail.next = newNode;

        // step3- tail=newNode
        tail = newNode;

        //make the list circular
        tail.next=head;
    }

    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        System.out.print(current.data+" ");
        current=current.next;
        while(current!=head) {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public void add(int data) {
        Node create=new Node(data);
        size++;
        if(head==null) {
            create.next=create;
            head=create;
            return;
        }
        tail.next=null;
        create.next=head;
        head=create;
        tail.next=head;
    }
    
    public void last(int data) {
        Node temp=new Node(data);
        size++;
        if(head==null) {
            temp=head=tail;
            return;
        }
        tail.next=null;
        tail.next=temp;
        temp.next=head;
        tail=temp;
    }

    public void middle(int idx, int data) {
        Node prev=new Node(data);
        size++;
        if(head==null) {
            prev=head=tail;
            return;
        }
        Node temp=head;
        int i=0;
        
        while(i<idx-1) {
            temp=temp.next;
            i++;
        }
        prev.next=temp.next;
        temp.next=prev;
        
    }

    public void deletefirst() {
        if(head==null) {
            size=0;
            return;
        }
        if(head.next==null) {
            head=tail=null;
            size=0;
            return;
        }
        tail.next=null;
        head=head.next;
        tail.next=head;
        size--;
    }

    public void deletelast() {
        if(head==null) {
            size=0;
            return;
        }
        if(head.next==null) {
            head=tail=null;
            size=0;
            return;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++) {
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        temp.next=head;
        size--; 
    }
        // do{  
        //         //Prints each node by incrementing pointer.  
        //         System.out.print(" "+ current.data);  
        //         current = current.next;  
        //     }while(current != head);  
        //     System.out.println();  
        // }  
    public static void main(String[] args) {
        circular ll = new circular();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.display();
        ll.add(6);
        ll.display();
        ll.last(7);
        ll.display();
        ll.middle(2,9);
        ll.display();
        ll.deletefirst();
        ll.display();
        ll.deletelast();
        ll.display();
        
    }
}
