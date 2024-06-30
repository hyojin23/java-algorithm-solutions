package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Find_Subset;

import java.util.Scanner;

public class Main_2nd {

    static int n;
    static int ch[];
    public void DFS(int L) {

        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ch = new int[n + 1];

        T.DFS(1);
    }
}
