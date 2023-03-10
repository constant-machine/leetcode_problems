import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveSolution {
    private Boolean pacific = false;
    private Boolean atlantic = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i < heights.length; i++) {
            for (int j=0; j < heights[0].length; j++) {
                pacific = false;
                atlantic = false;
                Set<Point> visited = new HashSet<>();
                waterFlow(heights, i, j, visited);
                if (pacific && atlantic) {
                    List<Integer> point = new ArrayList<>(2);
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    private void waterFlow(int[][] heights, int i, int j, Set<Point> visited) {
        if (visited.contains(new Point(i, j))) {
            return;
        }

        if (i<=0 || j<=0) pacific = true;
        if (i>=heights.length-1 || j>=heights[0].length-1) atlantic = true;

        if (pacific && atlantic) {
            return;
        } else {
            visited.add(new Point(i, j));
            if ((i-1>=0) && (heights[i][j] >= heights[i-1][j])) {
                waterFlow(heights, i-1, j, visited);
            }
            if ((j-1>=0) && (heights[i][j] >= heights[i][j-1])) {
                waterFlow(heights, i, j-1, visited);
            }
            if ((i+1<heights.length) && (heights[i][j] >= heights[i+1][j])) {
                waterFlow(heights, i+1, j, visited);
            }
            if ((j+1<heights[0].length) && (heights[i][j] >= heights[i][j+1])) {
                waterFlow(heights, i, j+1, visited);
            }
        }
    }

    private class Point {
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Point oo)) return false;
            return (oo.i == this.i) && (oo.j == this.j);
        }

        public int hashCode() {
            return 31*this.i + this.j + 3;
        }
    }
}
