import java.util.LinkedList;
class LLcollection{
    public static void main(String[] args){
        LinkedList<String>list=new LinkedList<String>();
        //! Adding  elements to the list
        list.add("Apple");
        list.add("Banana");
        list.addFirst("Mango");
        list.addLast("Grapes");
        System.out.println(list);

        //* Adding element at specific index to the list
        list.add(3,"Pineapple");
        System.out.println(list);

        //! Size of the list
        System.out.println(list.size());

        //! getting  element at specific index
        System.out.println(list.get(1));
        
        //! Removing element in list
        //* Removing element at first position
        list.removeFirst();
        //* Removing element at last position
        list.removeLast();
        System.out.println(list);
        //* Removing element at specific index
        list.remove(2);
        System.out.println(list);

        //! loops in Linked list 
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");

        System.out.println(list.size());
    }

    
}