import java.util.*;
public class AHalloumiBoxes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);;
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            if(k==1){
                if(isSorted(a)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }else{
                System.out.println("YES");
            }
        }
        sc.close();
    }

    private static boolean isSorted(int[] a) {
        boolean check=true;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                check=false;
                break;
            }
        }        
        return check;
    }
}