class shorting{
    public static void main(String[] args){
        int n[]={6,9,3,5,2};
        // bubble sort
        // time complexity O(n^2)
        System.out.println("Unsorted Array: ");
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
        // for (int i=0;i<n.length-1;i++){
        //     for (int j=0;j<n.length-i-1;j++){
        //         if (n[j]>n[j+1]){
        //             int temp=n[j];
        //             // swap
        //             n[j]=n[j+1];
        //             n[j+1]=temp;
                    
        //         }
        //     }
        // }
        // System.out.println("Sorted Array: ");
        // for(int i=0;i<n.length;i++){
        //     System.out.print(n[i]+" ");
        // }
        


        // selection sort
        // time complexity=O(n^2)
        for (int i=0;i<n.length-1;i++){
            int smallest=i;

            for (int j=i+1;j<n.length;j++){
                if (n[smallest]>n[j]){
                    smallest=j;
                }
            }
            int temp=n[smallest];
            n[smallest]=n[i];
            n[i]=temp;
            
        }
        System.out.println("Sorted Array: ");
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }

        // // insertion sort
        for (int i=0;i<n.length;i++){
            int current=n[i];
            int j=i-1;
            while (j>=0 && current <n[j]){
                n[j+1]=n[j];
                j--;
            }

            // placement
            n[j+1]=current;
        }
        for (int i=0;i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }
} 