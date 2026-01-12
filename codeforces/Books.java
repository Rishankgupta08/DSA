import java.util.Scanner;
class Books{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i=0,j=0,max=0;
        for(i=0;i<n;i++){
            t-=arr[i];
            if(t<0){
                while(t<0){
                    t+=arr[j];
                    j++;
                }
            }
            max=Math.max(max,i-j+1);
        }
        System.out.println(max);
        sc.close();
    }
}