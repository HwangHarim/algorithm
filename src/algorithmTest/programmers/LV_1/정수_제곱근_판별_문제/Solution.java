package algorithmTest.programmers.LV_1.정수_제곱근_판별_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(25));
    }

    public static long solution(long n) {
        double sqrtNum = Math.sqrt(n);
        if(sqrtNum%1 !=0){
            return -1;
        }
        return (long) Math.pow(sqrtNum+1, sqrtNum+1);
    }
}
/*
*Math.pow = 제곱
* Math.sqrt = 루트
* **/
