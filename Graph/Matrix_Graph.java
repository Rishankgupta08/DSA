package Graph;

import java.util.Scanner;
class Matrix_Graph{
    public static void main(String[] args){
        int N, e;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        e=sc.nextInt();
        int[][] mat=new int[e+1][e+1];
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            mat[u][v]=1;
            mat[v][u]=1;
        }
        for(int i=0;i<e+1;i++){
            for(int j=0;j<e+1;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}