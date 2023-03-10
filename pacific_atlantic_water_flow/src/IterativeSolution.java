import java.util.*;

public class IterativeSolution {

    private Boolean pacific = false;
    private Boolean atlantic = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i < heights.length; i++) {
            for (int j=0; j < heights[0].length; j++) {
                pacific = false;
                atlantic = false;
                waterFlow(heights, i, j);
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

    private void waterFlow(int[][] heights, int ii, int jj) {
        LinkedList<Point> stack = new LinkedList<>();
        stack.push(new Point(ii, jj));

        Set<Point> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            var point = stack.pop();
            int i = point.i;
            int j = point.j;

            if (i==0 || j==0) pacific = true;
            if (i==heights.length-1 || j==heights[0].length-1) atlantic = true;
            if (pacific && atlantic) return;

            visited.add(point);
            if ((i-1>=0) && !visited.contains(new Point(i-1, j)) && heights[i][j] >= heights[i-1][j]) {
                stack.push(new Point(i-1, j));
            }
            if ((j-1>=0) && !visited.contains(new Point(i, j-1)) && heights[i][j] >= heights[i][j-1]) {
                stack.push(new Point(i, j-1));
            }
            if ((i+1<heights.length) && !visited.contains(new Point(i+1, j)) && heights[i][j] >= heights[i+1][j]) {
                stack.push(new Point(i+1, j));
            }
            if ((j+1<heights[0].length) && !visited.contains(new Point(i, j+1)) && heights[i][j] >= heights[i][j+1]) {
                stack.push(new Point(i, j+1));
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
