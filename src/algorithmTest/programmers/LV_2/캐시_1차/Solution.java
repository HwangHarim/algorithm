package algorithmTest.programmers.LV_2.캐시_1차;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cacheList = new ArrayList<>();
        int count =0;
        if(cacheSize == 0){
            return 5*cities.length;
        }

        cacheList.add(".");

        for(String name : cities){
            String city = name.toLowerCase();
            if(count<cacheSize){
                if(!cacheList.contains(city)){
                    if(count == 0){
                        cacheList.remove(0);
                    }
                    count++;
                    answer +=5;
                    cacheList.add(city);
                    continue;
                }
                cacheList.remove(city);
                cacheList.add(city);
                answer++;
            }else{
                if(!cacheList.contains(city)){
                    answer +=5;
                    cacheList.remove(0);
                    cacheList.add(city);
                    continue;
                }
                cacheList.remove(city);
                cacheList.add(city);
                answer++;
            }
        }

        return answer;
    }
}
