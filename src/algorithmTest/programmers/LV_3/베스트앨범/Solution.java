package algorithmTest.programmers.LV_3.베스트앨범;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static class SongInfo{
        int index;
        int playCount;

        public SongInfo(int index, int playCount){
            this.index = index;
            this.playCount = playCount;
        }
    }

    static Map<String, Integer> songRankMap = new HashMap<>();
    static List<String> songRankList = new ArrayList<>();
    static List<Integer> songRankCountList = new ArrayList<>();
    static Map<String, List<SongInfo>> songMap = new HashMap<>();


    public static List<Integer> solution(String[] genres, int[] plays) {
        for(int i =0; i < genres.length; i++){
            songRankMap.put(genres[i],songRankMap.getOrDefault(genres[i], 0)+plays[i]);

            songMap.put(genres[i], songMap.getOrDefault(genres[i], new ArrayList<>()));
            songMap.get(genres[i]).add(new SongInfo(i, plays[i]));
        }

        for(Map.Entry<String, Integer> map : songRankMap.entrySet()){
            songRankCountList.add(map.getValue());
        }

        Collections.sort(songRankCountList, Collections.reverseOrder());

        for(Integer song : songRankCountList){
            for(Map.Entry<String, Integer> map : songRankMap.entrySet()){
                if(song == map.getValue()){
                    songRankList.add(map.getKey());
                }
            }
        }

        for(Map.Entry<String, List<SongInfo>> map : songMap.entrySet()){
            Collections.sort(map.getValue(), (o1, o2) ->{
                if(o2.playCount == o1.playCount){
                    return o1.index - o2.index;
                }
                return o2.playCount - o1.playCount;
            });
        }


        List<Integer> answer = new ArrayList<>();

        for(int i =0; i< songRankList.size()*2;i+=2){
            List<SongInfo> info = songMap.get(songRankList.get(i/2));
            answer.add(info.get(0).index);
            answer.add(info.get(1).index);
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] a ={"classic", "pop", "classic", "classic", "pop"};
        int[] b = {500, 600, 150, 800, 2500};
        int[] c ={4, 1, 3, 0};

        solution(a, b);
    }
}
