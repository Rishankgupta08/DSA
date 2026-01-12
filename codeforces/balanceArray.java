import java.util.Scanner;
import java.util.HashMap;
public class balanceArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int ans=countelement(a);
            System.out.println(ans);
        }
        sc.close();
    }
    public static int countelement(int[] a){
        int n=a.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int count=0;
        for(int i: map.keySet()){
            int c=map.get(i);
            if(c>=i){
                count+=c-i;
            }else{
                count+=c;
            }
        }
        return count;
    }
}