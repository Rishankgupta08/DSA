import java.util.Arrays;
import java.util.Scanner;
class Apartments{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int j=0;j<m;j++){
            b[j]=sc.nextInt();
        }
        int ans=apartment(a,b,k);
        System.out.println(ans);
    }
    public static int apartment(int[] a,int[] b,int k){
        int n=a.length;
        int m=b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        int count=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(Math.abs(a[i]-b[j])<=k){
                count++;
                i++;
                j++;
            }else if(a[i]<b[j]){
                i++;
            }else{
                j++;
            }
        }
        return count;
    }
}