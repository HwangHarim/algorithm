package algorithmTest.programmers.LV_1.소수_만들기_문제;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,7,6,4};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        boolean chk = false;

        for (int i = 0; i < nums.length; i++) {
           for(int j = i+1; j < nums.length; j++){
               for (int k = j+1; k < nums.length; k++) {
                   int result = nums[i] +nums[j]+nums[k];
                   if(result>=2){
                      chk= sosu(result);
                   }
                   if(chk){
                       answer++;
                   }
               }
           }
        }
       return answer;
    }

    public static boolean sosu(int result){
        boolean check = true;

        if(result==2) { //소수일때
            return check;
        }
        for(int i=2; i<result; i++) { //소수가 아닐때
            if(result%i ==0) {
                check = false;
                break;
            }
        }
        return check;
    }
}
