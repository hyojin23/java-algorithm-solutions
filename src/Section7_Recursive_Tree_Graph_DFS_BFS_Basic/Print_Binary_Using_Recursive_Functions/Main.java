package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Print_Binary_Using_Recursive_Functions;

import java.util.Scanner;

public class Main {

    public void DFS(int n) {

        if (n == 0) {
            return;
        }
        else {
            int a = n / 2;
            int b = n % 2;
            DFS(a);
            System.out.print(b);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.DFS(n);
    }
}
