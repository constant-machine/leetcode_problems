import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix[0].length;
        int n = matrix.length;;

        int indentX = 0; // up to matrix[0].length / 2;
        int indentY = 0; // up to matrix.length / 2;

        int i = 0;
        int j = 0;

        do {

            if ((m - 2*indentX) == 0) break;
            i = indentY;
            for (j = indentX; j < (m - indentX); j++) {
                result.add(matrix[i][j]);
            }
            j--;

            if ((n - 2*indentY) == 1) break;
            for (i = indentY + 1; i < (n - indentY); i++) {
                result.add(matrix[i][j]);
            }
            i--;

            if ((m - 2*indentX) == 1) break;
            for (j = m - indentX - 2; j >= indentX; j--) {
                result.add(matrix[i][j]);
            }
            j++;

            if ((n - 2*indentY) == 2) break;
            for (i = n - indentY - 2; i > indentY; i--) {
                result.add(matrix[i][j]);
            }

            indentX++;
            indentY++;

        } while ((indentX <= matrix[0].length / 2) && (indentY <= matrix.length / 2));

        return result;
    }
}
