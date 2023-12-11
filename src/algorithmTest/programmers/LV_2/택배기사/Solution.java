package algorithmTest.programmers.LV_2.택배기사;

class Solution {
    public int solution(String[] board) {
        final String O = "o";
        final String X = "x";
        final String DOT = ".";

        boolean[][] oVisited = new boolean[3][3];
        boolean[][] xVisited = new boolean[3][3];

        int answer = 1;
        int oCount = 0;
        int xCount = 0;


        for(int i =0; i<3;i++){
            String[] attack = board[i].split("");

            for(int j =0; j<3; j++){
                if(attack[j].equals(DOT)){
                    continue;
                }
                if(attack[j].equals(O)){
                    oVisited[i][j] = true;
                    oCount++;
                    continue;
                }
                if(attack[j].equals(X)){
                    xVisited[i][j] = true;
                    xCount++;
                }
            }
        }


        if(xCount ==0 && oCount ==0){
            return 1;
        }

        if(Math.abs(oCount-xCount) <0 || 1 < Math.abs(oCount-xCount)){
            return 0;
        }

        if(2 < oCount || 2<xCount){
            boolean xVictor = false;
            boolean oVictor = false;

            if(oVisited[0][0] &&oVisited[1][1] &&oVisited[2][2]){
                oVictor = true;

            }
            if(xVisited[0][2] &&xVisited[1][1] &&xVisited[0][2]){
                xVictor = true;
            }

            for(int i =0; i<3;i++){
                if(oVisited[i][0] &&oVisited[i][1] &&oVisited[i][2]){
                    oVictor = true;

                }
                if(xVisited[i][0] &&xVisited[i][1] &&xVisited[i][2]){
                    xVictor = true;
                }
            }

            for(int j =0; j<3; j++){
                if(oVisited[0][j] &&oVisited[1][j] &&oVisited[2][j]){
                    oVictor = true;
                }
                if(xVisited[0][j] &&xVisited[1][j] &&xVisited[2][j]){
                    xVictor = true;
                }
            }

            if(xVictor&&oVictor){
                return 0;
            }
        }

        return answer;
    }
}