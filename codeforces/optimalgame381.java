import java.util.Scanner;
public class optimalgame381{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int s1=0;
        int s2=0;
        int left=0;
        int right=n-1;
        boolean turn = true;
        while(left<=right){
            if(turn){
                s1+=Math.max(nums[left],nums[right]);
                if(nums[left]>nums[right]){
                    left++;
                }else{
                    right--;
                }
                turn= false;
            }else{
                s2+=Math.max(nums[left],nums[right]);
                if(nums[left]>nums[right]){
                    left++;
                }else{
                    right--;
                }
                turn=true;
            }
        }
        System.out.println(s1+" "+s2);
        sc.close();
    }
}