package algorithmTest.programmers.LV_2.타켓넘버;

public class Solution {
    private static int answer = 0;
    private static  int[] numbers;

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        Solution.numbers = numbers;
        dfs(0,0, target);

        return answer;
    }

    public static void dfs(int level, int sum,int target){
        if(level == numbers.length){
            if(sum == target) {
                answer++;
            }
                return;
        }
            dfs(level+1, sum + numbers[level], target);
            dfs(level+1, sum - numbers[level], target);
    }
}