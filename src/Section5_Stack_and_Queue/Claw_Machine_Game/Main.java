package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int col_idx;
        Stack<Integer> stack = new Stack<>();
        for (int x : moves) {
            col_idx = x - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col_idx] != 0) {
                    int tmp = board[i][col_idx];
                    board[i][col_idx] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
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
        System.out.println(T.solution(board, moves));
    }
}
