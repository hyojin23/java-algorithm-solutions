package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Recursive_Function;

import java.util.Scanner;

public class Main_1st {
    public void solution(int n) {

        print(n);
    }

    public void print(int n) {

        if (n == 0)
            return;

        print(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
