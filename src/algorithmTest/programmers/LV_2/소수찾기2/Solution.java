package algorithmTest.programmers.LV_2.소수찾기2;


class Solution {
    static int answer=0;
    static String[] init;
    static boolean[] visited;
    static String result="";

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {

        init = numbers.split("");
        visited = new boolean[init.length];
        for(int i=1;i<=numbers.length();i++){
            dfs(i);
        }

        return answer;
    }

    public static void dfs(int size){

        if(result.length() == size){
            if(check(result)){
                answer++;
            }
            result="";
            return;
        }
        if(size<result.length()){
            result="";
            return;
        }

        for(int i=0;i<init.length;i++){
            if(1<size&&result.length() == 0 && init[i].equals("0")){
                    continue;
            }
            if(!visited[i]){
                visited[i] = true;
                result = result + init[i];
                dfs(size);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String result){
        int number = Integer.parseInt(result);

        if(number<2){
            return false;
        }
        return ((number % 2) != 0) && ((number % 3) != 0);
    }
}