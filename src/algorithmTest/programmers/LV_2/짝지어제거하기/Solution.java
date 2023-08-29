package algorithmTest.programmers.LV_2.짝지어제거하기;

import java.util.*;

import java.util.*;

class Solution
{
    int answer = 0;

    public int solution(String s)
    {

        List<String> str = new ArrayList<>(Arrays.asList(s.split("")));
        dfs(str);

        return answer;
    }

    public void dfs(List<String> str){
        if((str.size()==2) && (str.get(0).equals(str.get(1)))){
            answer =1;
            return;
        }

        for(int i=0; i<str.size();i++){
            if((str.size()-1 != i) && str.get(i).equals(str.get(i+1))){
                str.remove(i+1);
                str.remove(i);

                dfs(str);
            }
        }
    }
}
