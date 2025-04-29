import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y  = y;
    }
}

public class Main {

    static int R, C;
    static char board[][];
    static int[][] ch;
    static int cnt = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(Queue<Point> q) {

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && ch[nx][ny] == 0) {
                    if (board[nx][ny] == '.') {
                        ch[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                    if (board[nx][ny] == 'S') {
                        if (board[p.x][p.y] == '.') {
                            board[p.x][p.y] = 'D';
                        }
                        else if (board[p.x][p.y] == 'W') {
                            cnt++;
                        }
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        board = new char[R][C];
        ch = new int[R][C];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'W') {
                    ch[i][j] = 1;
                    q.offer(new Point(i, j));
                }
            }
        }
        T.BFS(q);

        if (cnt > 0) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}
