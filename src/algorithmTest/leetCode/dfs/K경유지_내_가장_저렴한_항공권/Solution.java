package algorithmTest.leetCode.dfs.K경유지_내_가장_저렴한_항공권;

import java.util.*;

class Solution {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int[] flight : flights){
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src,0,0));
        Map<Integer, Integer> visited = new HashMap<>();

        while(!pq.isEmpty()){
            List<Integer> cur = pq.poll();

            int u = cur.get(0);
            int price_u = cur.get(1);
            int k_visited = cur.get(2);

            if(u==dst)
                return price_u;

            visited.put(u, k_visited);

            if(k_visited <=k){
                k_visited +=1;
                if(map.containsKey(u)){
                    for(Map.Entry<Integer, Integer> v : map.get(u).entrySet()){
                        if(!visited.containsKey(v.getKey())|| k_visited< visited.get(v.getKey())){
                            int alt = price_u + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }
        }

        return -1;
    }

}