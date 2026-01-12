class ReversestrRecurr{
    public static void Printrev(String str,int idx){
        if (idx==0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        Printrev(str,idx-1);
        //! time complexity== O(n)
    }
    public static void main(String[] args){
        String str="abcd";
        Printrev(str,str.length()-1);

    }
}