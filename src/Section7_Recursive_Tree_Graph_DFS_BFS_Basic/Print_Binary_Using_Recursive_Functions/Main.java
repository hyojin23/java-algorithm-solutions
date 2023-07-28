package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Print_Binary_Using_Recursive_Functions;

import java.util.Scanner;

public class Main {

    public void solution(int n) {

        print(n);
    }

    public void print(int n) {

        if (n == 0) {
            return;
        }
        else {
            print(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String args[]) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
