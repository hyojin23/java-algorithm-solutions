package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Fibonacci_Sequence;

import java.util.Scanner;
public class Main {

    static int[] arr;
    public int DFS(int n) {

        if (arr[n] > 0) return arr[n];

        if (n == 1) {
            return arr[n] = 1;
        }
        else if (n == 2) {
            return arr[n] = 1;
        }
        else {
            return arr[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n + 1];

        T.DFS(n);

        for (int i = 1; i <= n; i++) {
           System.out.print(arr[i] + " ");
        }
    }
}
