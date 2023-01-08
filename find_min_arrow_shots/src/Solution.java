import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(e -> e[1]));

    int arrows = 1;
    int endPoint = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > endPoint) {
        arrows++;
        endPoint = points[i][1];
      }
    }
    return arrows;
  }
}
