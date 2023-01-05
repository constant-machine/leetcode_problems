import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k > 0) {

            int carry = grid[grid.length-1][grid[0].length-1];
            int temp = 0;
            for (int i=0; i < grid.length; i++) {
                for (int j=0; j < grid[i].length; j++) {
                    int temp1;
                    if (j == 0 && grid[i].length != 1) {
                        temp = grid[i][j];
                        grid[i][j] = carry;
                    } else if (j == 0 && grid[i].length == 1) {
                        temp1 = grid[i][j];
                        grid[i][j] = carry;
                        carry = temp1;
                    } else if (j == grid[i].length-1) {
                        carry = grid[i][j];
                        grid[i][j] = temp;
                    } else {
                        temp1 = grid[i][j];
                        grid[i][j] = temp;
                        temp = temp1;
                    }
                }
            }

            k--;
        }

        List<List<Integer>> result = new ArrayList<>(grid.length);
        for (int i=0; i < grid.length; i++) {
            result.add(new ArrayList<>(grid[i].length));
            for (int j=0; j < grid[0].length; j++) {
                result.get(i).add(grid[i][j]);
            }
        }
        return result;
    }
}
