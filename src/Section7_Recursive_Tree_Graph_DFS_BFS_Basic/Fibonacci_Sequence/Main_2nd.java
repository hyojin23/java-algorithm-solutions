package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Fibonacci_Sequence;

import java.util.Scanner;

public class Main_2nd {

    public int DFS(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return DFS(n - 1) + DFS(n - 2);
        }
    }


    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(T.DFS(i) + " ");
        }
    }
}
