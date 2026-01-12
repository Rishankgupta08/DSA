class DeletenNodeafterMnodes{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    public Node deleteNodeAfterMNodes(Node head, int M, int N) {
        Node current = head;
        while (current != null) {
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                break;
            }
            Node temp = current.next;
            for (int j = 0; j < N && temp != null; j++) {
                temp = temp.next;
            }
            current.next = temp;
            current = temp;
        }
        return head;
    }
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DeletenNodeafterMnodes list = new DeletenNodeafterMnodes();
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(5);
        list.head.next.next.next.next.next = list.new Node(6);
        list.head.next.next.next.next.next.next = list.new Node(7);
        list.head.next.next.next.next.next.next.next = list.new Node(8);
        int M = 3, N = 2;
        System.out.println("Original List:");
        list.printList(list.head);
        list.head = list.deleteNodeAfterMNodes(list.head, M, N);
        System.out.println("Modified List after deleting " + N + " nodes after every " + M + " nodes:");
        list.printList(list.head);
    }
}