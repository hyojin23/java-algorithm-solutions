package BOJ.BOJ1992;

import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    static int[][] board;

    public void quadTree(int x, int y, int size) {

        if (isPossible(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append('(');
        int newSize = size / 2;
        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);
        sb.append(')');
    }

    public boolean isPossible(int x, int y, int size) {

        int val = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - 48;
            }
        }
        sb = new StringBuilder();
        T.quadTree(0, 0, N);
        System.out.println(sb);
    }
}
