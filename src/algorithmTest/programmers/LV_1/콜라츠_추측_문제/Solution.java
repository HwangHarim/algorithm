package algorithmTest.programmers.LV_1.콜라츠_추측_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }
    public static int solution(int num) {
        int count =0;
        int nums = num;

        while(nums!=1){
            nums = (nums%2==0) ? nums/2 : 3*nums+1;
            count++;
            if(count == 500) {
                count = -1;
                break;
            }
        }
        return count;
    }
}
