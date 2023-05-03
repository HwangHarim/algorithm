package algorithmTest.programmers.LV_1.하샤드수_문제;

public class Solution {

    public static void main(String[] args) {

    }


    public boolean solution(int x) {
        int sum =0;
        String[] init = String.valueOf(x).split("");
        for(String s : init){
            sum+= Integer.parseInt(s);
        }
        return x % sum == 0;
    }
}
