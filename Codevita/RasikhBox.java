import java.util.*;
public class RasikhBox {
    public static char[][] applyGravity(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        for (int col = 0; col < cols; col++) {
            int emptyRow = rows - 1;
            for (int row = rows - 1; row >= 0; row--) {
                if (box[row][col] == '*') {
                    if (row != emptyRow) {
                        box[emptyRow][col] = '*';
                        box[row][col] = '.';
                    }
                    emptyRow--;
                }
            }
        }
        return box;
    }
    public static char[][] rotateRight(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] newBox = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newBox[j][rows - 1 - i] = box[i][j];
            }
        }
        
        return newBox;
    }
    public static char[][] rotateLeft(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] newBox = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newBox[cols - 1 - j][i] = box[i][j];
            }
        }
        
        return newBox;
    }
    public static void printBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                System.out.print(box[i][j]);
                if (j < box[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine(); 
        char[][] box = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                box[i][j] = row[j].charAt(0);
            }
        }
        box = applyGravity(box);
        int k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            String instruction = sc.nextLine().trim();
            if (instruction.equals("right")) {
                box = rotateRight(box);
            } else if (instruction.equals("left")) {
                box = rotateLeft(box);
            }
            box = applyGravity(box);
        }
        printBox(box);
        sc.close();
    }
}
