package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Path_Adjacent_Matrix;

import java.util.Scanner;

public class Main_1st {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {


        if (v == n) {
            answer++;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
        }
        ch[1] = 1;
        T.DFS(1);

        System.out.println(answer);
    }
}



