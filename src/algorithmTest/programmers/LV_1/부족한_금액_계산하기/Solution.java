package algorithmTest.programmers.LV_1.부족한_금액_계산하기;

public class Solution {

    public static void main(String[] args) {

    }

    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <=count; i++) {
          answer += (long) price * i;
        }
        answer -=money;
        return answer;
    }

}
