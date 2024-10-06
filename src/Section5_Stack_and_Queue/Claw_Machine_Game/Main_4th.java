package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main_4th {

    public int solution(int n, int m, int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i : moves) {
            for (int j = 0; j < n; j++) {
                if (board[j][i - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][i - 1]) {
                        stack.pop();
                        cnt = cnt + 2;
                    }
                    else {
                        stack.push(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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

