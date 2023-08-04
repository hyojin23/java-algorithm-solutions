package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Fibonacci_Sequence;

import java.util.Scanner;

public class Main {

    static int[] fibo;

    public void solution(int n) {

        fibo = new int[n + 1];

        fibonacci(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int fibonacci(int n) {

        if (fibo[n] > 0)
            return fibo[n];

        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        else {
            return fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
