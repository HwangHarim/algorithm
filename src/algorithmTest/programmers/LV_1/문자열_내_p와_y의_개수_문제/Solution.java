package algorithmTest.programmers.LV_1.문자열_내_p와_y의_개수_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyyY"));
    }

    static boolean solution(String s) {
        int p_count =0;
        int y_count = 0;

        String init = s.toLowerCase();
        for(String initial : init.split("")){
            if(initial.equals("p")){
                p_count++;
            }
            if(initial.equals("y")){
                y_count++;
            }
        }
        return (p_count==y_count) ? true : false;
    }

}
