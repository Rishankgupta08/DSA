class Add{
    public static int  add(int n){
        if(n==0){
            return 0;
        }
        return n%10+add(n/10);
    }
    public static void main(String[] args){
        int n=345;
        System.out.println(add(n));
    }
}