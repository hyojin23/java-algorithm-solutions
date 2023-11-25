package Section8_Use_DFS_BFS.Distance_Of_Pizza_Delivery;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point {

    int x, y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[] combi;
    static List<Point> hList;
    static List<Point> pList;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {

            int wpdd = 0;

            for (Point h : hList) {
                int pdd = Integer.MAX_VALUE;
                for (int i : combi) {
                    int dis = Math.abs(h.x - pList.get(i).x) + Math.abs(h.y - pList.get(i).y);

                    pdd = Math.min(pdd, dis);
                }
                wpdd += pdd;
            }

            answer = Math.min(answer, wpdd);

        } else {
            for (int i = s; i < pList.size(); i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][n];
        combi = new int[m];

        hList = new ArrayList<>();
        pList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int a = sc.nextInt();
                board[i][j] = a;

                if (a == 1) {
                    hList.add(new Point(i, j));
                }
                else if (a == 2) {
                    pList.add(new Point(i, j));
                }
            }
        }

        T.DFS(0, 0);

        System.out.println(answer);
    }
}
