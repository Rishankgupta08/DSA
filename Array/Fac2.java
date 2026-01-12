class Fac2{
    public static void main(String args[]){
        int[] arr={1,2,3,4,5};
        for(int i=0;i<arr.length;i++){
            System.out.print(fac(arr[i])+" ");
        }
    }
    public static int fac(int n){
        if(n==0){
            return 1;
        }
        return n*fac(n-1);
    }
}