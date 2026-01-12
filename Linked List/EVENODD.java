class EVENODD {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public Node evenodd(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next; // save next
            temp.next = null; // break old link

            if (temp.data % 2 == 0) { // even
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            } else { // odd
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }

            temp = nextNode; // move ahead
        }

        // Join odd list with even list
        if (oddHead == null) return evenHead;
        if (evenHead == null) return oddHead;

        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        EVENODD list = new EVENODD();
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(5);
        list.head.next.next.next.next.next = list.new Node(6);

        list.head = list.evenodd(list.head);

        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
