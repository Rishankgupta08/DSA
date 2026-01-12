class PallindromicLL{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void AddFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void PrintList(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
        }
        System.out.println("Null");
    }

    public Node reverseList() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head=prev;
        return prev;
    }
    public boolean isPalindrome() {
        if(head==null || head.next==null){
            return true;
        }
        Node Rh=reverseList();
        Node temp=head;
        Node curr=Rh;
        while(temp!=null && curr!=null){
            if(temp.data != curr.data){
                return false;
            }
            temp=temp.next;
            curr=curr.next;
        }
        return true;

    }
    public static void main(String[] args){
        PallindromicLL ll=new PallindromicLL();
        ll.AddFirst(1);
        ll.AddFirst(2);
        ll.AddFirst(1);
        ll.AddFirst(1);
        ll.PrintList();
        System.out.println(ll.isPalindrome());
    }
}