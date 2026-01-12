class LL{
    private int size;
    LL(){
        this.size=0;
    }

    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    
    //! Adding  a node at the start of the linked list
    public void AddFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //! Adding  a node at the end of the linked list
    public void AddLast(String data){
        Node newNode=new Node(data);
        if(head== null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    //! Print  the linked list
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

    //! Delete the  node of the linked list
    // *First Node
    public void DeleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        head=head.next;
        
    }
    //* Last Node
    public void DeleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secondLast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
        
    }

    //! Size of list 
    public int getSize(){
        return size;
    }

    //! Reverse of a list 
    public void reverseIterate(){
        if(head==null || head.next==null){
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }

    
    //! Main function
    public static void main(String args[]){
        LL list=new LL();
        list.AddFirst("Rishank");
        list.AddFirst("am");
        list.PrintList();
        list.AddLast("Gupta");
        list.PrintList();
        list.AddFirst("I");
        list.PrintList();
        list.DeleteFirst();
        list.PrintList();
        list.DeleteLast();
        list.PrintList();
        System.out.println(list.getSize());
        list.AddFirst("Hii");
        list.AddFirst("hello");
        list.PrintList();
        list.reverseIterate();
        list.PrintList();
        System.out.println("Size od List: "+list.getSize());
        
   }
}