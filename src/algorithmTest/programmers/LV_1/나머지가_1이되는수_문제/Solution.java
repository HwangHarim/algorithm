package algorithmTest.programmers.LV_1.나머지가_1이되는수_문제;

public class Solution {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(n%i==1){
                answer = i;
                break;
            }
        }

        return answer;
    }

}
