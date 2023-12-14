package algorithmTest.programmers.LV_2.혼자_놀기의_달인;

import java.util.*;


class Solution {
    static List<Integer> countList = new ArrayList<>();
    static boolean[] visited;
    static int count =0;
    static int[] cardArr;

    public static void main(String[] args) {
        int[] a = {8,6,3,7,2,5,1,4};
        System.out.println(solution(a));
    }

    public static int solution(int[] cards) {
        visited = new boolean[101];
        cardArr = cards;

        for(int i=0;i<cardArr.length;i++){
            if(!visited[cardArr[i]]){
                count=0;
                dfs(cardArr[i]);
                countList.add(count);
            }
        }

        if(countList.size()==1){
            return 0;
        }

        countList.sort(Collections.reverseOrder());

        return countList.get(0)*countList.get(1);
    }

    public static void dfs(int index){
        visited[index] = true;
        count++;
        if(!visited[cardArr[index-1]]){
            dfs(cardArr[index-1]);
        }
    }
}