package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Fibonacci_Sequence;

import java.util.Scanner;

public class Main_7th {

    static int[] arr;

    public int DFS(int n) {

        if (arr[n] > 0) {
            return arr[n];
        }

        if (n == 1 || n == 2) {
            return arr[n] = 1;
        }
        else {
            return arr[n] = DFS(n - 1) + DFS(n -2);
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n + 1];

        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
