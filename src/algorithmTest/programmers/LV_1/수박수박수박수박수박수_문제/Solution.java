package algorithmTest.programmers.LV_1.수박수박수박수박수박수_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        String answer = "";
        for(int i = 1; i <=n; i++){
            if(i%2==0){
                answer += "박";
                continue;
            }
            answer += "수";
        }

        return answer;
    }
}
