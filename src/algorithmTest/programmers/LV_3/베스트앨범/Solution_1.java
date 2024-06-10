package algorithmTest.programmers.LV_3.베스트앨범;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Solution {

    Map<String, Integer> songRankMap = new HashMap<>();
    Map<String, List<int[]>> songMap = new HashMap<>();
    List<Integer> answer = new ArrayList<>();

    public List<Integer> solution(String[] genres, int[] plays) {

        for(int i =0; i< genres.length; i++){
            songRankMap.put(genres[i], songRankMap.getOrDefault(genres[i],0)+plays[i]);
            songMap.put(genres[i], songMap.getOrDefault(genres[i],new ArrayList<>()));
            songMap.get(genres[i]).add(new int[] {i, plays[i]});

        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(songRankMap.entrySet());

        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for(Map.Entry<String, Integer> map : entries){
            String key = map.getKey();

            List<int[]> song = songMap.get(key);

            Collections.sort(song, (o1,o2) -> {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o2[1]- o1[1];
            });

            if(song.size()<2){
                answer.add(song.get(0)[0]);
            } else{
                answer.add(song.get(0)[0]);
                answer.add(song.get(1)[0]);
            }
        }

        return answer;
    }
}
