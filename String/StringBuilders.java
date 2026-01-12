class StringBuilders{
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder("Rishank");
        // char at index '0'
        System.out.println(sb.charAt(0));
        // set char at index '0'
        sb.setCharAt(0,'R');
        System.out.println(sb);
        // insert 
        sb.insert(0,'S');
        System.out.println(sb);

        // delete
        sb.delete(0,1);
        System.out.println(sb);

        // appending or adding
        sb.append("G");
        System.out.println(sb);


        // reverse of a string 
        for (int i=0;i<sb.length()/2;i++){
            int f=i;
            int b=sb.length()-1-i;
            char fc=sb.charAt(f);
            char bc=sb.charAt(b);
            sb.setCharAt(f,bc);
            sb.setCharAt(b,fc);
            System.out.println(sb);
            
        }





    }
}