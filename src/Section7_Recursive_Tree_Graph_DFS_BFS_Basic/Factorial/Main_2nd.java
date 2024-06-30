package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Factorial;

import java.util.Scanner;

public class Main_2nd {

    public int DFS(int n) {

        if (n == 1) {
            return 1;
        }
        else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.DFS(n));
    }
}
