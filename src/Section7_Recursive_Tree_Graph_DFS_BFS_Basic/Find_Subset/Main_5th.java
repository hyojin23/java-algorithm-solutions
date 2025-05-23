package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Find_Subset;

import java.util.Scanner;

public class Main_5th {

    static int[] arr;
    static int n;

    public void DFS(int L) {

        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
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

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1];

        T.DFS(1);
    }
}
