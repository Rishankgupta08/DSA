import java.util.Scanner;
class Gone{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            long a=sc.nextLong();
            long b=sc.nextLong();

            
            String s2=String.valueOf(b);
            Long[][][] dp1=new Long[s2.length()][2][165];
            long right = solve(s2, 0, 1, 0, dp1);
            long left=0;
            if(a>1){
                String s1=String.valueOf(a-1);    
                Long[][][] dp2=new Long[s1.length()][2][165];
                left=solve(s1, 0, 1, 0, dp2);
            }
            System.out.println(right-left);
        } 
    }
    public static long solve(String s,int idx,int tight,int sum,Long[][][] dp){
            if(idx==s.length()){
                if(isprime(sum)){
                    return 1;
                }else{
                    return 0;
                }
            }
            if(dp[idx][tight][sum]!=null){
                return dp[idx][tight][sum];
            }
            int lb=0;
            int ub=(tight==1)? s.charAt(idx)-'0': 9;

            long res=0;
            for(int digit=lb;digit<=ub;digit++){
                int newTight=(tight==1 && digit==ub)? 1 : 0;
                res+=solve(s,idx+1,newTight,sum+digit,dp);
            }
            return dp[idx][tight][sum]=res;
    }
        public static boolean isprime(int n){
            if(n<=1){
                return false;
            }
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        
    }
    
}