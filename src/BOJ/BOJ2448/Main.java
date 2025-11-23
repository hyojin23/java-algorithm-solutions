package BOJ.BOJ2448;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static char[][] arr;
    public void solution(int N) {

        arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                arr[i][j] = ' ';
            }
        }

        drawStar(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }

    //r:삼각형 꼭대기 행, c:삼각형 꼭대기 열, n:삼각형 높이
    public void drawStar(int r, int c, int n) {

        if (n == 3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = '*';
            arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 1] = '*';
            arr[r + 2][c - 2] = '*';
            arr[r + 2][c] = '*';
            arr[r + 2][c + 1] = '*';
            arr[r + 2][c + 2] = '*';
            return;
        }

        int half = n / 2;

        //위쪽 삼각형
        drawStar(r, c, half);
        //왼쪽 아래 삼각형
        drawStar(r + half, c - half, half);
        //오른쪽 아래 삼각형
        drawStar(r + half, c + half, half);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        T.solution(N);
    }
}
