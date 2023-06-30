package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main_v2 {

    public int solution(int n, int[][] board, int m, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            for (int j = 0; j < n; j++) {
                if (board[j][i - 1] != 0) {
                    if (stack.size() > 0 && stack.peek() == board[j][i - 1]) {
                        stack.pop();
                        answer += 2;
                    }
                    else {
                        stack.push(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
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
        System.out.println(T.solution(n, board, m, moves));
    }
}
