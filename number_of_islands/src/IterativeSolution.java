import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class IterativeSolution {
    private final Set<Point> visited = new HashSet<>();

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Point(i,j))) {
                    exploreIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void exploreIsland(char[][] grid, int i, int j) {

        LinkedList<Point> stack = new LinkedList<>();
        stack.push(new Point(i, j));
        while (!stack.isEmpty()) {
            var point = stack.pop();
            int ii = point.i;
            int jj = point.j;
            if ((ii > 0) && (grid[ii -1][jj] != '0') && !visited.contains(new Point(ii -1,jj))) {
                var upPoint = new Point(ii -1, jj);
                stack.push(upPoint);
                visited.add(upPoint);
            }

            if ((jj > 0) && (grid[ii][jj-1] != '0') && !visited.contains(new Point(ii,jj-1))) {
                var leftPoint = new Point(ii, jj-1);
                stack.push(leftPoint);
                visited.add(leftPoint);
            }

            if ((ii < grid.length-1) && (grid[ii +1][jj] != '0') && !visited.contains(new Point(ii +1,jj))) {
                var downPoint = new Point(ii +1,jj);
                stack.push(downPoint);
                visited.add(downPoint);
            }

            if ((jj < grid[0].length-1) && (grid[ii][jj+1] != '0') && !visited.contains(new Point(ii,jj+1))) {
                var rightPoint = new Point(ii,jj+1);
                stack.push(rightPoint);
                visited.add(rightPoint);
            }
        }
    }

    class Point {
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Point point)) return false;
            return (point.i == this.i) && (point.j == this.j);
        }

        public int hashCode() {
            return 31*this.i + this.j + 7;
        }
    }
}
