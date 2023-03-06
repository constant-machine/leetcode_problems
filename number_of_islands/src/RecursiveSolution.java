import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RecursiveSolution {
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
        if ((i<0 || j<0) || (i>=grid.length || j>=grid[0].length)) {
            return;
        } else if (grid[i][j] == '0' || visited.contains(new Point(i,j))) {
            return;
        } else {
            visited.add(new Point(i, j));
            exploreIsland(grid, i-1, j);
            exploreIsland(grid, i, j-1);
            exploreIsland(grid, i+1, j);
            exploreIsland(grid, i, j+1);
            return;
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
