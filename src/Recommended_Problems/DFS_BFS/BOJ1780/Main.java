package Recommended_Problems.DFS_BFS.BOJ1780;

import java.util.Scanner;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int[][] paper;
    static int[] answer;

    public boolean isPossible(Point tl, Point br) {

        int rowCnt = br.y - tl.y + 1;
        int colCnt = br.x - tl.x + 1;
        int tlVal = paper[tl.x][tl.y];
        for (int i = tl.x; i < tl.x + rowCnt; i++) {
            for (int j = tl.y; j < tl.y + colCnt; j++) {
                if (paper[i][j] != tlVal) {
                    return false;
                }
            }
        }
        return true;
    }

    public void DFS(Point tl, Point br) {

        if (isPossible(tl, br)) {
            answer[paper[tl.x][tl.y] + 1]++;
        }
        else {
            int xx = (br.x - tl.x + 1) / 3;
            int yy = (br.y - tl.y + 1) / 3;
            for (int i = tl.x; i <= br.x; i+=xx) {
                for (int j = tl.y; j <= br.y; j+=yy) {
                    DFS(new Point(i, j), new Point(i + xx - 1, j + yy - 1));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        paper = new int[N][N];
        answer = new int[3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        T.DFS(new Point(0, 0), new Point(N - 1, N -1));
        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }
}
