import java.util.ArrayList;
import java.util.Collections;

class ArrayLists{
    public static void main(String[]  args){
        ArrayList<Integer>list=new ArrayList<Integer>();
        
        // Addition of elements in Arraylist
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        // checking element by their indexes
        int a=list.get(3);
        System.out.println(a);

        // putting element at any index
        list.add(1,7);
        System.out.println(list);

        // changing or setting an element
        list.set(0,9);
        System.out.println(list);

        //  deleting an element 
        list.remove(5);
        System.out.println(list);

        // size of list
        int size=list.size();
        System.out.println(size);

        // loops in ArrayList
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // Sorting
        Collections.sort(list);
        System.out.println(list);
    }
}