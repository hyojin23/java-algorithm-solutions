package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Find_Subset;

import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;

    public void DFS(int L) {
        if (L == n) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }
        else {
            arr[L] = 1;
            DFS(L + 1);
            arr[L] = 0;
            DFS(L + 1);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1];
        T.DFS(0);
    }
}
