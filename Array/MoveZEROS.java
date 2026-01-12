class MoveZEROS{
    public static void main(String[] args){
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
    public static void moveZeroes(int[] arr){
        int nonZeroPos = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[nonZeroPos] = arr[i];
                nonZeroPos++;
            }
        }
        while(nonZeroPos < arr.length) {
            arr[nonZeroPos] = 0;
            nonZeroPos++;
        }
    }
}