import java.util.LinkedList;
import java.util.Collections;
class LLReverse{
    public  static void main(String[] args){
        LinkedList<String>list=new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("Original List: " + list);
        Collections.reverse(list);
        System.out.println("Reversed List: " + list);
    }
}