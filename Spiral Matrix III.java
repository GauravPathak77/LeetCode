class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int answer[][] = new int[rows*cols][2];
        answer[0][0] = rStart;
        answer[0][1] = cStart;
        boolean[][] visited = new boolean[rows][cols];
        helper(rStart,cStart,rows,cols,answer,visited,1 , 1);
        return answer;

        
    }
    void helper(int curr_row, int curr_col , int rows, int cols , int[][] answer , boolean[][] visited , int counter,int ind){
        
         int row = curr_row;
         int col = curr_col;
         boolean flag = false;
        for(int i=1;i<=counter;i++){

            row = row;
            col = col+1;
            if(col<cols && col>=0 && row>=0 && row<rows){
                flag = true;
                answer[ind][0]=row;
                answer[ind][1]=col;
                visited[row][col]=true;
                ind++;
            } 
        }
        for(int i=1;i<=counter;i++){

            row = row+1;
            col = col;
            if(row<rows && row>=0 && col>=0 && col<cols){
                flag = true;
                answer[ind][0] = row;
                answer[ind][1] = col;
                 visited[row][col]=true;
                ind++;
            }

        }
        counter++;

        for(int i=1;i<=counter;i++){

            row=row;
            col=col-1;
            if(col>=0 && col<cols &&  row>=0 && row<rows){
                flag = true;
                answer[ind][0]=row;
                answer[ind][1]=col;
                 visited[row][col]=true;
                ind++;
            }
        }

        for(int i=1;i<=counter;i++){

            row = row-1;
            col = col;
            if(row>=0 && row<rows && col>=0 && col<cols){
                flag = true;
                answer[ind][0]=row;
                answer[ind][1]=col;
                visited[row][col]=true;
                ind++;
            }
        }
        if(flag)
        helper(row,col,rows,cols,answer,visited,counter+1,ind);
 
    }
}
