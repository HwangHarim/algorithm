package algorithmTest.leetCode.dfs.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//시간 초과
class Solution {
    List<Integer> startId = new ArrayList<>();
    boolean[] visited;
    List<List<String>> answer = new ArrayList<>();
    List<List<String>> tickets;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.size()];

        for(int i = 0; i < tickets.size(); i++) {
            if(tickets.get(i).get(0).equals("JFK")) {
                startId.add(i);
            }
        }

        for(int index : startId) {
            List<String> trip = new ArrayList<>();
            trip.add("JFK");
            trip.add(tickets.get(index).get(1));
            visited[index] = true;

            dfs(index, trip);
            visited[index] = false; // 롤백
        }

        Collections.sort(answer, (list1, list2) -> {
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                int result = list1.get(i).compareTo(list2.get(i));
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        });

        return answer.isEmpty() ? new ArrayList<>() : answer.get(0);
    }

    public void dfs(int index, List<String> trip){
        if(trip.size() == tickets.size() + 1){
            answer.add(new ArrayList<>(trip));
            return;
        }

        for(int i = 0; i < tickets.size(); i++){
            if(!visited[i] && trip.get(trip.size() - 1).equals(tickets.get(i).get(0))){
                visited[i] = true;
                trip.add(tickets.get(i).get(1));

                dfs(i, trip);

                // 롤백
                visited[i] = false;
                trip.remove(trip.size() - 1);
            }
        }
    }
}