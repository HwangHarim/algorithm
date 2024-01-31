package algorithmTest.programmers.LV_2.예상_대진표;

public class Solution {
    // 내풀이
    public int solution(int n, int a, int b) {
        int answer = 0;
        int nowA = a;
        int nowB = b;

        while(true){
            answer++;
            if(Math.abs(nowA-nowB) == 1){
                if(nowA%2==1 && nowA+1 == nowB){
                    break;
                }else if(nowB%2 == 1 && nowB+1 == nowA){
                    break;
                }
            }
            if(nowA % 2 != 0){
                nowA = (nowA+1)/2;
            }else{
                nowA /= 2;
            }
            if(nowB % 2 != 0){
                nowB = (nowB+1)/2;
            }else{
                nowB /= 2;
            }

        }
        return answer;
    }
}
/**
 *  더 좋은 풀이
 *     public int solution(int n, int a, int b)
 *     {
 *         int round = 0;
 *         while(a != b)
 *         {
 *             a = a/2 + a%2;
 *             b = b/2 + b%2;
 *             round++;
 *         }
 *         return round;
 *     }
 */
