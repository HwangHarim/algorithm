package algorithmTest.programmers.LV_1.평균_구하기_문제;

public class Solution {

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,9};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;
        for(int i : arr){
            answer +=i;
        }
        return answer/arr.length;
    }

}
