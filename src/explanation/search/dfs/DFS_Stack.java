package explanation.search.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DFS_Stack {

    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static ArrayList<Integer> dfsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int line = sc.nextInt();
        int startVertex =sc.nextInt();

        arrayList = new ArrayList[vertex+1];
        for(int i =0; i<arrayList.length; i++){
            arrayList[i] = new ArrayList<>();
        }

        visited = new boolean[vertex+1];

        for(int i=0; i<line;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for(int i=1;i<vertex+1;i++){
            Collections.sort(arrayList[i]);
        }
    }
}