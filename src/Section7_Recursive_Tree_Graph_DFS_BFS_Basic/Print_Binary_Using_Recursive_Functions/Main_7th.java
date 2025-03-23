package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Print_Binary_Using_Recursive_Functions;

import java.util.Scanner;

public class Main_7th {

    public void DFS(int n) {

        if (n == 0) {
            return;
        }
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        T.DFS(n);
    }
}
