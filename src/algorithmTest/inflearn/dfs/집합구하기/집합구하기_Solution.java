package algorithmTest.inflearn.dfs.집합구하기;

import java.util.Scanner;

public class 집합구하기_Solution {

    static class Main {

        static int[] ch;

        static int input1;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            input1 = sc.nextInt();
            ch = new int[input1 + 1];
            dfs(1);
        }

        public static void dfs(int level) {
            if (level == input1+1) {
                for(int i=1;i<ch.length;i++){
                    if(ch[i] ==1){
                        System.out.print(i +" ");
                    }
                }
                System.out.println();
            } else {
                ch[level] = 1;
                dfs(level + 1);
                ch[level] = 0;
                dfs(level + 1);
            }
        }
    }
}
