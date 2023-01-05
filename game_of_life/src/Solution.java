public class Solution {

    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            result[i] = new int[board[i].length];
        }

        int tl, tm, tr, ml, mr, dl, dm, dr;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (((i-1) < 0) || ((j-1) < 0)) tl = 0; else tl = board[i-1][j-1];
                if ((i-1) < 0) tm = 0; else tm = board[i-1][j];
                if (((i-1) < 0) || ((j+1) >= board[i].length)) tr = 0; else tr = board[i-1][j+1];

                if ((j-1) < 0) ml = 0; else ml = board[i][j-1];
                if ((j+1) >= board[i].length) mr = 0; else mr = board[i][j+1];

                if (((i+1) >= board.length) || ((j-1) < 0)) dl = 0; else dl = board[i+1][j-1];
                if ((i+1) >= board.length) dm = 0; else dm = board[i+1][j];
                if (((i+1) >= board.length) || ((j+1) >= board[i].length)) dr = 0; else dr = board[i+1][j+1];

                int sum = tl + tm + tr + ml + mr + dl + dm + dr;
                if (board[i][j] == 1) {
                    if (sum < 2) result[i][j] = 0;
                    if (sum == 2 || sum == 3) result[i][j] = 1;
                    if (sum > 3) result[i][j] = 0;
                } else {
                    if (sum == 3) result[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board[i].length);
        }
    }
}
