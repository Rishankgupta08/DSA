import java.util.Scanner;

public class SecondLargestFinder {

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; 
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; 
                largest = num; 
            } else if (num > secondLargest && num != largest) {
                secondLargest = num; 
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        if (size < 2) {
            System.out.println("Second largest element doesn't exist.");
            
        }
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int result = findSecondLargest(arr);
        System.out.println("Second Largest Element: " + result);
        sc.close();
    }
}
