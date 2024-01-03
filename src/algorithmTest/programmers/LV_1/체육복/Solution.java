package algorithmTest.programmers.LV_1.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] readyStudy = new int[n+1];
        Arrays.fill(readyStudy, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);


        for(int lostStudent : lost){
            readyStudy[lostStudent] -= 1;
        }

        for(int reserveStudent : reserve){
            readyStudy[reserveStudent] += 1;
        }

        for(int reserveStudent : reserve){

            int up = reserveStudent +1;
            int down = reserveStudent -1;

            if(0 < down && readyStudy[down] == 0 && readyStudy[reserveStudent] == 2){
                readyStudy[reserveStudent] = 1;
                readyStudy[down] = 1;
                continue;
            }

            if(up <= n && readyStudy[up] == 0&&readyStudy[reserveStudent] == 2){
                readyStudy[reserveStudent] = 1;
                readyStudy[up] = 1;
            }
        }

        for(int student : readyStudy){
            if(0 < student){
                answer += 1;
            }
        }

        return answer-1;
    }
}