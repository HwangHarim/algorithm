package algorithmTest.programmers.LV_3.단어_변환;

public class Solution {
    static int answer=51;


    public static void main(String[] args) {
        String begin ="hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }
    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited,0);

        if(answer == 51){
            return 0;
        }
        return answer;
    }

    private static void dfs(String begin, String target, String[] words, boolean[] visited, int count){
        if(begin.equals(target)){
            answer =Math.min(answer, count);
            return;
        }
            for(int i =0; i< words.length;i++) {

                if (!visited[i] && countDefalte(begin, words[i])) {
                    visited[i] = true;
                    dfs(words[i], target, words, visited, count+1);
                    visited[i] = false;
                }
            }
    }

    private static boolean countDefalte(String begin, String word){
        int count =0;
        String[] begins = begin.split("");
        String[] words = word.split("");

        for(int i =0; i<begins.length;i++){
            if(begins[i].equals(words[i])){
                count++;
            }
        }
        if(count == begins.length-1){
            return true;
        }
        return false;
    }

}
