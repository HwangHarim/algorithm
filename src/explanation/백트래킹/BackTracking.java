package explanation.백트래킹;

public class BackTracking {

    public static void main(String[] args) {

    }

    public void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            System.out.println(arr);
        }

        for(int i= start;i<n;i++){
            visited[i] = true;
            combination(arr, visited, i+1,n,r-1);
            visited[i] = false;
        }
    }
}
