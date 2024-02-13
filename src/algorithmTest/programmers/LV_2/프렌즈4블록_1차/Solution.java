package algorithmTest.programmers.LV_2.프렌즈4블록_1차;

class Solution {
    static int answer =0;
    static String[][] boardMap;
    static boolean[][] boardVisited;
    static int M, N;

    public static int solution(int m, int n, String[] board) {
        boardVisited = new boolean[m][n];
        boardMap = new String[m][n];
        M =m;
        N =n;
        for(int i =0; i<board.length; i++){
            String[] boardArr = board[i].split("");
            for(int j =0; j<boardArr.length;j++){
                boardMap[i][j] = boardArr[j];
            }
        }

        while(true){
            for(int i =1; i<m;i++){
                for(int j =1; j<n; j++){
                    checkBox(j, i);
                }
            }
            if(!checkGame()){
                break;
            }
            countAnswer();
            resetBoardMap();
            boardVisited = new boolean[m][n];
        }

        return answer;
    }

    public static void resetBoardMap(){
        for(int i = M -2; 0<=i; i--){
            for(int j = N -1; 0<=j; j--){
                if(boardMap[i][j].equals("")){
                    continue;
                }
                int ny = i;
                while(!boardMap[ny][j].equals("")&&boardMap[ny+1][j].equals("")&& ny<M-2){
                    boardMap[ny+1][j] = boardMap[ny][j];
                    boardMap[ny][j] = "";
                    ny++;
                }
                if(boardMap[M-1][j].equals("")&&!boardMap[M-2][j].equals("")){
                    boardMap[M-1][j] = boardMap[M-2][j];
                    boardMap[M-2][j] ="";
                }
            }
        }
    }

    public static void countAnswer(){
        for(int i =0; i< M;i++){
            for(int j =0; j< N; j++){
                if(boardVisited[i][j]){
                    answer++;
                    boardVisited[i][j] = false;
                    boardMap[i][j] ="";
                }
            }
        }
    }

    public static boolean checkBox(int x, int y){
        if(boardMap[y][x].equals(boardMap[y-1][x]) &&
            boardMap[y][x].equals(boardMap[y-1][x-1]) &&
            boardMap[y][x].equals(boardMap[y][x-1]) &&
            !boardMap[y][x].equals("")){
            boardVisited[y][x] = true;
            boardVisited[y][x-1] = true;
            boardVisited[y-1][x] = true;
            boardVisited[y-1][x-1] = true;

            return true;
        }
        return false;
    }

    public static boolean checkGame(){
        for(int i =0; i< M;i++){
            for(int j =0; j< N; j++){
                if(boardVisited[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] a ={"AAAAAA", "BBAATB", "BBAATB", "JJJTAA","JJJTAA"};
        System.out.println(solution(5,6 , a));
    }
}