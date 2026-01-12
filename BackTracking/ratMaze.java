class ratMaze{
    public static void main(String[] args){
        int r=3;
        int col=3;
        boolean[][] visited=new boolean[r][col];
        print(0,0,r-1,col-1,"",visited);
    }
    public static void print(int i,int j,int row,int col,String s,boolean[][] visited){
        if(i<0 || j<0){
            return;
        }
        if(i>row|| j>col){
            return;
        }
        if(i==row && j==col){
            System.out.println(s);
            return;
        }
        if(visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        print(i+1,j,row,col,s+"D",visited);
        print(i,j-1,row,col,s+"L",visited);
        print(i-1,j,row,col,s+"U",visited);
        print(i,j+1,row,col,s+"R",visited);
        visited[i][j]=false;
    }
}