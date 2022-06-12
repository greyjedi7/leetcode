public class Prob4 {


    Boolean [][][]status;

    public boolean dfs(int i, int j, int balance,char[][] grid){

        if(i >= grid.length || j >= grid[0].length){
            return false;
        }


        int updatedBalance = 0;
        
        if(grid[i][j] == ')'){
            updatedBalance = balance - 1;
        } else {
            updatedBalance = balance + 1;
        }

        

        if(i == grid.length-1 && j == grid[0].length-1 && updatedBalance == 0){
            return true;
        } else if(i == grid.length-1 && j == grid[0].length-1 && updatedBalance != 0) {
            return false;
        }

        if(updatedBalance < 0){
            return false;
        }

        if(status[i][j][updatedBalance] != null){
            return status[i][j][updatedBalance];
        }

        boolean result = dfs(i+1,j,updatedBalance, grid) || dfs(i,j+1,updatedBalance,grid);

        status[i][j][updatedBalance] = result;

        return result;
    }

    public boolean hasValidPath(char[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        status = new Boolean[m][n][m+n];


        return dfs(0,0,0,grid);
    }

    
    public static void main(String[] args){

    }

}
