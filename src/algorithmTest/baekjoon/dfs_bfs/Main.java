package algorithmTest.baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] board;
    static boolean[] bfsVisited;
    static boolean[] dfsVisited;

    static StringBuffer dfsAnswer = new StringBuffer();
    static StringBuffer bfsAnswer = new StringBuffer();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];
        board = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            board[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x].add(y);
            board[y].add(x);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(board[i]);
        }

        dfs(v);

        bw.write(dfsAnswer.toString().substring(0,dfsAnswer.length()-1));
        bw.newLine();

        bfs(v);
        bw.write(bfsAnswer.toString().substring(0,bfsAnswer.length()-1));

        br.close();
        bw.close();


    }

    public static void dfs(int index){
        dfsVisited[index] = true;
        dfsAnswer.append(index).append(" ");
        for(int i=0; i<board[index].size();i++){
            if(!dfsVisited[board[index].get(i)]){
                dfs(board[index].get(i));
            }
        }
    }

    public static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        bfsVisited[index] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            bfsAnswer.append(now).append(" ");
            for(int i=0; i<board[now].size();i++){
                if(!bfsVisited[board[now].get(i)]){
                    bfsVisited[board[now].get(i)] =true;
                    q.offer(board[now].get(i));
                }
            }
        }
    }
}
//var 컴파일러 알아서 해주니까 가독성 때문에 사용한다? import를 사용 할 필요가 없어서 코드가 줄어든다.