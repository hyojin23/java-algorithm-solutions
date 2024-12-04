package Section5_Stack_and_Queue.Claw_Machine_Game;

import java.util.Scanner;
import java.util.Stack;

public class Main_6th {

    public int solution(int n, int m, int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int pos : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][pos] != 0) {
                    int doll = board[i][pos];
                    board[i][pos] = 0;
                    if (stack.isEmpty()) {
                        stack.push(doll);
                    }
                    else {
                        if (stack.peek() == doll) {
                            stack.pop();
                            answer = answer + 2;
                        }
                        else {
                            stack.push(doll);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
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
