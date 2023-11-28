package algorithmTest.programmers.LV_2.Queens;

class Solution {
    static int[] leftDown = {-1,-1};
    static int[] leftUp = {-1,1};
    static int[] rigthUp = {1,1};
    static int[] rigthDown = {1,-1};

    static boolean[][] board;
    static boolean[] queens;

    static int answer;
    static int N;

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        N= n;
        board = new boolean[n][n];
        queens = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j =0; j < n;j++){
                dfs(new Point(i,j), 0);
            }
            int count=0;
            for(boolean queen : queens){
                if(queen){
                    count++;
                }
            }
            if(count == n){
                answer++;
            }

            board = new boolean[n][n];
            queens = new boolean[n];
        }
        return answer;
    }



    public static void dfs(Point point, int level){


        int x = point.x;
        int y = point.y;
        queens[level] = true;

        for(int i=0; i<N; i++){
            board[y][i] = true;
            board[i][x] = true;
        }

        int tmpX = x;
        int tmpY = y;
        while(0<=tmpX&&tmpX<N&&0<=tmpY&&tmpY<N){
            board[tmpY][tmpX] = true;
            tmpX += rigthUp[0];
            tmpY += rigthUp[1];
        }

        tmpX = x;
        tmpY = y;
        while(0<=tmpX&&tmpX<N&&0<=tmpY&&tmpY<N){
            board[tmpY][tmpX] = true;
            tmpX += rigthDown[0];
            tmpY += rigthDown[1];
        }

        tmpX = x;
        tmpY = y;
        while(0<=tmpX&&tmpX<N&&0<=tmpY&&tmpY<N){
            board[tmpY][tmpX] = true;
            tmpX += leftDown[0];
            tmpY += leftDown[1];
        }

        tmpX = x;
        tmpY = y;

        while(0<=tmpX&&tmpX<N&&0<=tmpY&&tmpY<N){
            board[tmpY][tmpX] = true;
            tmpX += leftUp[0];
            tmpY += leftUp[1];
        }

        for(int i=0; i < N; i++){
            for(int j =0; j < N;j++){
                if(!board[i][j]){
                    dfs(new Point(j, i), level+1);
                }
            }
        }
    }

    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
