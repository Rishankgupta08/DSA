class MissingNumber{
    public static void main(String[] args){
        int[] arr={2,0,1,4,5};
        int res=missingnumber(arr);
        System.out.println(res);
    }
    public static int missingnumber(int[] arr){
        int n=arr.length;
        int total=(n*(n+1))/2;
        int curr=0;
        for(int i: arr){
            curr+=i;
        }
        int ans=total-curr;
        return ans;
    }
}