package BOJ.BOJ15685;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static boolean[][] board;
    public static void drawLine(int x, int y, int d, int g) {

        List<Integer> dirList = getDirList(d, g);
        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};

        board[y][x] = true;
        for (int dir : dirList) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            board[ny][nx] = true;
            y = ny;
            x = nx;
        }
    }

    public static List<Integer> getDirList(int d, int g) {

        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }
        return list;
    }

    public static boolean isValidSquare(int y, int x) {

        int[] dy = {0, 0, 1, 1};
        int[] dx = {0, 1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                return false;
            }
            if (!board[ny][nx]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            drawLine(x, y, d, g);
        }

        int answer = 0;
        for (int y = 0; y <= 100; y++) {
            for (int x = 0; x <= 100; x++) {
                if (board[y][x]) {
                    if (isValidSquare(y, x)) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
