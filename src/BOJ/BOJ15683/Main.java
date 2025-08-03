package BOJ.BOJ15683;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, num;

    Point(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main {

    static int N, M, totCnt, answer = Integer.MAX_VALUE;
    static int[] arr;
    static int[][] board;
    static List<Point> cctvList;
    static List<int[]> dirList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int L, int areaCnt, int[][] curBoard) {
        if (L == cctvList.size()) {
            answer = Math.min(answer, totCnt - areaCnt);
        }
        else {
            for (int rotate = 0; rotate < 4; rotate++) {
                Point cctv = cctvList.get(L);
                if (cctv.num == 2 && rotate > 1) {
                    continue;
                }
                if (cctv.num == 5 && rotate > 0) {
                    continue;
                }
                arr[L] = rotate;
                int monitoredCnt = 0;
                int[][] newBoard = arrCopy(curBoard);
                for (int dir : dirList.get(cctv.num)) {
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(cctv.x, cctv.y, cctv.num));
                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        int newDir = (dir + rotate) % 4;
                        int nx = cur.x + dx[newDir];
                        int ny = cur.y + dy[newDir];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && newBoard[nx][ny] != 6) {
                            q.offer(new Point(nx, ny, cctv.num));
                            if (newBoard[nx][ny] == 0) {
                                newBoard[nx][ny] = 9;
                                monitoredCnt++;
                            }
                        }
                    }
                }
                DFS(L + 1, areaCnt + monitoredCnt, newBoard);
            }
        }
    }

    public static int[][] arrCopy(int[][] orgArr) {

        int[][] newArr = new int[orgArr.length][];
        for (int i = 0; i < orgArr.length; i++) {
            newArr[i] = orgArr[i].clone();
        }
        return newArr;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        cctvList = new ArrayList<>();
        dirList = new ArrayList<>();
        totCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvList.add(new Point(i, j, board[i][j]));
                }
                if (board[i][j] == 0) {
                    totCnt++;
                }
            }
        }
        dirList.add(new int[]{0});
        dirList.add(new int[]{0});
        dirList.add(new int[]{1, 3});
        dirList.add(new int[]{0, 1});
        dirList.add(new int[]{0, 1, 3});
        dirList.add(new int[]{0, 1, 2, 3});

        arr = new int[cctvList.size()];
        T.DFS(0, 0, board);
        System.out.println(answer);
    }
}
