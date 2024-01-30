package algorithmTest.programmers.LV_2.방문길이;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    public static int solution(String dirs) {
        Point[][] points = new Point[11][11];
        int answer = 0;
        int x = 5;
        int y = 5;

        for(int i=0; i<11; i++){
            for(int j=0;j<11;j++){
                points[i][j] = new Point();
            }
        }

        for(String mark : dirs.split("")){
            if(mark.equals("U")){
                points[y][x].top = true;
                y+=1;
                if(10<y){
                    y = 10;
                }
                if(points[y-1][x].top!=points[y][x].bottom){
                    answer++;
                }
                points[y][x].bottom = true;

            }else if(mark.equals("R")){
                points[y][x].right = true;
                x+=1;
                if(10<x){
                    x = 10;
                    continue;
                }
                if(points[y][x].left!=points[y][x-1].right){
                    answer++;
                }
                points[y][x].left = true;

            }else if(mark.equals("L")){
                points[y][x].left = true;
                x-=1;
                if(x<0){
                    x = 0;
                    continue;
                }
                if(points[y][x].right!=points[y][x+1].left){
                    answer++;
                }
                points[y][x].right = true;

            }else if(mark.equals("D")){
                points[y][x].bottom = true;
                y-=1;
                if(y<0){
                    y = 0;
                    continue;
                }
                if(points[y][x].top != points[y+1][x].bottom){
                    answer++;
                }
                points[y][x].top = true;
            }
        }
        return answer;
    }

    static class Point{
        public boolean top, bottom, right, left = false;
    }

}
