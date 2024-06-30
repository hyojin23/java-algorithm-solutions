package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Path_Adjacent_Matrix;

import java.util.Scanner;

public class Main_2nd {

    static int n = 0;
    static int[][] graph;
    static int[] ch;
    static int answer = 0;

    public void DFS(int v) {

        if (v == n) {
            answer++;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0 && graph[v][i] == 1) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
