package algorithmTest.programmers.LV_3.Hash;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[]{500, 600, 150, 800, 2500}));

    }

    public static List<Integer> solution(String[] genres, int[] plays) {

        Map<String, Integer> songMap = new HashMap<>();
        Map<String, ArrayList<int[]>> categoryMap = new HashMap<>();
        List<String> rank = new ArrayList<>();
        List<String> playCategory = new ArrayList<>();
        List<Integer> playCount = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (String genre : genres) {
            if (!rank.contains(genre)) {
                rank.add(genre);
            }
        }

        for (String genre : genres) {
            songMap.put(genre, 0);
            categoryMap.put(genre, categoryMap.getOrDefault(genre, new ArrayList<>()));
        }

        for (int i = 0; i < plays.length; i++) {
            songMap.put(genres[i], songMap.get(genres[i]) + plays[i]);
            categoryMap.get(genres[i]).add(new int[]{i, plays[i]});
            categoryMap.put(genres[i], categoryMap.get(genres[i]));
        }

        for (Map.Entry<String, Integer> category : songMap.entrySet()) {
            playCount.add(category.getValue());
            playCount.sort(Collections.reverseOrder());
        }

        for (int count : playCount) {
            for (Map.Entry<String, Integer> category : songMap.entrySet()) {
                if (category.getValue() == count) {
                    playCategory.add(category.getKey());
                }
            }
        }

        for (String category : playCategory) {
            ArrayList<int[]> result = categoryMap.get(category);
            if(result.size()<2){
                answer.add(result.get(0)[0]);
                continue;
            }
            result.sort(
                Comparator.<int[], Integer>comparing(arr -> arr[1], Comparator.reverseOrder())
                    .thenComparing(arr -> arr[0]));

            for (int i =0; i<2;i++) {
                answer.add(result.get(i)[0]);
            }
        }

        return answer;
    }
}
