package explanation.search.dfs.연결요소의개수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i =1;i<n+1;i++){
            A[i] = new ArrayList<>();
        }
        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[s].add(s);
        }
        int count =0;
        for(int i =1; i<n+1;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }
    static void dfs(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i:A[v]){
            if(visited[i]==false){
                dfs(i);
            }
        }
    }
}
