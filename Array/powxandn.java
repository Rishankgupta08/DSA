class powxandn{
    public static void main(String[] args){
        int x=3;
        int n=5;
        double res=pow(x,n);
        System.out.println(res);
    }
    public static double pow(int x,int n){
        long bin=n;
        if(n<0){
            x=1/x;
            bin=-bin;
        }
        double ans=1;
        while(bin>0){
            if(bin%2==1){
                ans*=x;
            }
            x*=x;
            bin/=2;
        }
        return ans;
    }
}