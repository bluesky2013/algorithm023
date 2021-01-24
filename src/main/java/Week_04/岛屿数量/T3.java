package Week_04.岛屿数量;

/**
 * 岛屿数量
 */
public class T3 {

    private void removeOne(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        removeOne(grid, i, j-1);
        removeOne(grid, i, j+1);
        removeOne(grid, i-1, j);
        removeOne(grid, i+1, j);

    }
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    result += 1;
                    removeOne(grid, i, j);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//                };
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
};


        System.out.println(new T3().numIslands(grid));

    }

}
