import java.util.*;
class LinearSearch{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Size of an Array: ");
        int size=sc.nextInt();
        int num[]=new int[size];
        System.out.println("Enter the Elements: ");
        for (int i=0;i<size;i++){
            num[i]=sc.nextInt();
        }
        System.out.print("Enter the No. to Search: ");
        int x=sc.nextInt();
        for(int i=0;i<num.length;i++){
            if (num[i]==x){
                System.out.println("X found at index: "+i);
                return;
            } 
        }
        System.out.println("X not found");
        sc.close();
    }
}