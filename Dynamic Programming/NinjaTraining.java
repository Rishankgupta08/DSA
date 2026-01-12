class NinjaTraining{
    public static void main(String[] args){
        int[][] points={{10,40,70},{20,50,80},{30,60,90}};
        int n=3;
        int ans=solve(points,n-1,3);
        System.out.println(ans);
    }
    public static int solve(int[][] points,int n,int last){
        if(n==0){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(last!=i){
                    max=Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(last!=i){
                max=Math.max(max,solve(points,n-1,i)+points[n][i]);
            }
        }
        return max;
    }
}