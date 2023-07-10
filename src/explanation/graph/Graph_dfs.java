package explanation.graph;

import explanation.graph.Graph.Node;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    class Node{
         int data;
         LinkedList<Node> adjacent;
        boolean visited;
        public Node(int data){
            this.data = data;
            this.visited = false;
            adjacent = new LinkedList<>();
        }
    }

    static Node[] nodes;

    public Graph(int sizeNum) {
        nodes = new Node[sizeNum];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }

    public static void addEdges(int a, int b) {
        Node x1 = nodes[a];
        Node x2 = nodes[b];
        if (!x1.adjacent.contains(x2)) {
            x1.adjacent.add(x2);
        }
        if (!x2.adjacent.contains(x1)) {
            x2.adjacent.add(x1);
        }
    }

    static void dfs(Node x){
        if(x== null){
            System.out.println(x.data);
            return;
        }else{
            x.visited =true;
            System.out.println(x.data);
            for(Node ac : x.adjacent){
                if(!ac.visited){
                    dfs(ac);
                }
            }
        }
    }

    static void bfs(Node x){
        Queue<Node> q = new LinkedList<>();
        q.offer(x);
        x.visited = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            System.out.println(now.data);
            for(Node ac: now.adjacent){
                if(!ac.visited){
                    ac.visited = true;
                    q.offer(ac);
                }
            }
        }
    }
}
public class Graph_dfs{

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(1,3);
        graph.addEdges(2,4);
        graph.addEdges(2,3);
        graph.addEdges(3,4);
        graph.addEdges(3,5);
        graph.addEdges(5,6);
        graph.addEdges(5,7);
        graph.addEdges(6,8);
        Node root = graph.nodes[0];
        graph.bfs(root);
        //graph.dfs(root);

    }
}
