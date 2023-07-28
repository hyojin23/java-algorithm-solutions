package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Factorial;

import java.util.Scanner;

public class Main {

    public int solution(int n) {

        int answer = factorial(n);

        return answer;
    }

    public int factorial(int n) {

        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
