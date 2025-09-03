package BOJ.BOJ9663;

import java.util.Scanner;

public class Main {

    static int N, answer;
    static boolean[] cols, diag1, diag2;

    public void DFS(int row) {

        if (row == N) {
            answer++;
        }
        else {
            for (int col = 0; col < N; col++) {
                if (cols[col] || diag1[row + col] || diag2[row - col + N - 1]) {
                    continue;
                }
                cols[col] = true;
                diag1[row + col] = true;
                diag2[row - col + N - 1] = true;
                DFS(row + 1);
                cols[col] = false;
                diag1[row + col] = false;
                diag2[row - col + N - 1] = false;
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        cols = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2=  new boolean[2 * N];
        T.DFS(0);
        System.out.println(answer);
    }
}
