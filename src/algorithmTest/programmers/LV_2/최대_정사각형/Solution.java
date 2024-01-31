package algorithmTest.programmers.LV_2.최대_정사각형;

class Solution {

    public int solution(int[][] board) {
        int maxLen = 0;
        if (board.length == 1) {
            if (board[0][0] == 1) {
                return 1;
            }
            return 0;
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    int min = Math.min(Math.min(board[i][j - 1], board[i - 1][j - 1]),
                        board[i - 1][j]);
                    board[i][j] = min + 1;
                    maxLen = Math.max(maxLen, board[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
