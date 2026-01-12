class LLdel {
    Node head;

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node searchAndRemoveNthTerm(Node head, int n) {
        if (head == null) {
            return null; 
        }
        int size = 1;
        Node curr = head;
        while (curr.next != null) { 
            curr = curr.next;
            size++;
        }
        if (n > size) {
            System.out.println("Position out of range.");
            return head;
        }
        int ptf = size - n; 
        Node prev = head;
        int cp = 1;
        if (n == size) {
            System.out.println("Element at nth position from the end: " + head.data);
            return head.next;
        }
        while (cp != ptf) {
            prev = prev.next;
            cp++;
        }
        System.out.println("Element at nth position from the end: " + prev.next.data);
        prev.next = prev.next.next;
        return head;
    }

    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LLdel ll = new LLdel();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.print("Original List: ");
        ll.printList(ll.head);

        //! Search and delete the nth term from the end
        ll.head = ll.searchAndRemoveNthTerm(ll.head, 2);

        System.out.print("List after removing 2nd node from end: ");
        ll.printList(ll.head);
    }
}
