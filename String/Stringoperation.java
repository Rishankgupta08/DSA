class Stringoperation{


    public static void main(String[] args){
        // concatination
        String A = "Ram";
        String B = "Charan";
        String C=A +" "+ B;
        System.out.println(C);

        // length of string
        System.out.println(C.length());

        // use of charat function
        for (int i=0;i<B.length();i++){
            System.out.println(B.charAt(i));
        }

        // Compare string
        String name1="Rishank";
        String name2="RishanK";
        if (name1.compareTo(name2)==0){
            System.out.println("Equal!");
        }
        else{
            System.out.println("Not Equal!");
        }

        // Substring 
        String sentence="My Name is Rishank.";
        String name=sentence.substring(11,sentence.length());
        System.out.println(name);

    }
}