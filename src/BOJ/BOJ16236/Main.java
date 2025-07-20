package BOJ.BOJ16236;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point> {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point ob) {
        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main {

    static int N, ateCnt, sharkSize = 2, startX, startY;
    static int[][] board;

    public int BFS(int x, int y) {

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Point> q = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        q.offer(new Point(x, y));
        board[x][y] = 0;
        int L = 0;
        boolean[][] visited = new boolean[N][N];
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] <= sharkSize) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        if (board[nx][ny] != 0 && board[nx][ny] < sharkSize) {
                            list.add(new Point(nx, ny));
                        }

                    }
                }
            }
            L++;
            if (!list.isEmpty()) {
                Collections.sort(list);
                Point targetFish = list.get(0);
                board[targetFish.x][targetFish.y] = 9;
                ateCnt++;
                startX = targetFish.x;
                startY = targetFish.y;
                if (ateCnt == sharkSize) {
                    sharkSize++;
                    ateCnt = 0;
                }
                return L;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 9) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int answer = 0;
        while (true) {
            int minLen = T.BFS(startX, startY);
            if (minLen == 0) {
                break;
            }
            answer += minLen;
        }
        System.out.println(answer);
    }
}
