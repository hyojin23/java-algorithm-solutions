package BOJ.BOJ2447;

import java.util.Scanner;

public class Main {

    static int N;
    static char[][] arr;

    public void drawStar(int x, int y, int size, boolean blank) {

        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    drawStar(x + i * newSize, y + j * newSize, newSize, true);
                }
                else {
                    drawStar(x + i * newSize, y + j * newSize, newSize, false);
                }
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new char[N][N];
        T.drawStar(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
