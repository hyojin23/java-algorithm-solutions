package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main_5th {

    public int solution(int n, int m, int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int k : moves) {
            for (int i = 0; i < n; i++) {
                int pick =  board[i][k];
                if (pick == 0) {
                    continue;
                }

                board[i][k] = 0;

                if (!stack.isEmpty() && stack.peek() == pick) {
                    stack.pop();
                    cnt = cnt + 2;
                }
                else {
                    stack.push(pick);
                }

                break;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];

        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, board, moves));
    }
}
