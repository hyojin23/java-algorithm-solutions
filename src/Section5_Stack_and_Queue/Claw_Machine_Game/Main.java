package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(int n, int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int j : moves) {
            for (int i = 0; i < n; i++) {
                int pick = board[i][j - 1];
                board[i][j - 1] = 0;
                if (pick != 0) {
                    if (!stack.isEmpty() && stack.peek() == pick) {
                        stack.pop();
                        answer = answer + 2;
                    }
                    else {
                        stack.push(pick);
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

        System.out.println(T.solution(n, board, moves));
    }
}
