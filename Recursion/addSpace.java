class addSpace{
    public static void add(int n){
        if(n<10){
            System.out.print(n);
            return;
        }
        int rem=n%10;
        add(n/10);
        System.out.print("_"+rem);
    }
    public static void main(String[] args){
        int n=345;
        add(n);
    }
}