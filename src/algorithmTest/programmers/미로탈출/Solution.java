package algorithmTest.programmers.미로탈출;

class Solution {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static boolean[][] startMap;

    static int[] start = new int[2];
    static int[] lever = new int[2];
    static int[] end = new int[2];

    static int answer = Integer.MAX_VALUE;

    static int x, y;
    static boolean flag =false;

    public static void main(String[] args){
        String[] a = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(a));
    }

    public static int solution(String[] maps) {
        y = maps.length;
        x = maps[1].length();

        startMap = new boolean[y][x];

        for(int i =0; i<y;i++){
            for(int j=0; j<x; j++){
                if(maps[i].charAt(j) == 'O'){
                    startMap[i][j] = true;

                }else{
                    if(maps[i].charAt(j) == 'S'){
                        start[0] = j;
                        start[1] = i;
                        startMap[i][j] = true;
                    }else if(maps[i].charAt(j) == 'L'){
                        lever[0] = j;
                        lever[1] = i;
                        startMap[i][j] = true;

                        continue;
                    }else if(maps[i].charAt(j) == 'E'){
                        end[0] = j;
                        end[1] = i;

                        startMap[i][j] = true;
                    }
                }
            }

        }

        dfs(0, start[0], start[1]);
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    public static void dfs(int s, int xl, int yl){
        if(xl ==lever[0] && yl ==lever[1]){
            flag = true;
        }

        if(xl == end[0] && yl == end[1]){
            answer = Math.min(answer, s);
            flag = false;
            return;
        }

        startMap[yl][xl] = false;

        for(int i=0; i<4; i++){
            int nx = xl + dx[i];
            int ny = yl + dy[i];


            if(0 <= nx && nx < x && 0 <= ny && ny < y && startMap[ny][nx]){
                dfs(s+1, nx, ny);
                startMap[yl][xl] = true;
            }
        }
    }
}