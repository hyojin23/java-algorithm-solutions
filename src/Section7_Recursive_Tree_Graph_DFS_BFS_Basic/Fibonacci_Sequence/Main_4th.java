package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Fibonacci_Sequence;

import java.util.Scanner;

public class Main_4th {

    static int[] arr;

    public int DFS(int n) {

        if (arr[n] != 0) {
            return arr[n];
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return arr[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print(T.DFS(i) + " ");
        }
    }
}
