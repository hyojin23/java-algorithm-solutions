package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Path_Adjacent_Matrix;

import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int[] ch;
    static int n, m;
    static int answer = 0;

    public int DFS(int node) {

        if (node == n) {
            answer++;
        }
        else {
            for (int i = 1; i < n + 1; i++) {

                if (ch[i] == 0 && arr[node][i] == 1) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
        }
        ch[1] = 1;
        System.out.println(T.DFS(1));
    }
}
