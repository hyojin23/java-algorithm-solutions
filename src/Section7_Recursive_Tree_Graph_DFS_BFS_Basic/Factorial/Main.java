package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Factorial;

import java.util.Scanner;

public class Main {

    int answer = 1;
    public void DFS(int n) {

        if (n == 0) {
            System.out.println(answer);
        }
        else {
            answer *= n;
            DFS(n - 1);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.DFS(n);
    }
}
