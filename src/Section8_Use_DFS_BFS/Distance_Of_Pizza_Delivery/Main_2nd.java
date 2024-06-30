package Section8_Use_DFS_BFS.Distance_Of_Pizza_Delivery;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point_2nd {

    int x, y;

    public Point_2nd(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Main_2nd {

    static int n, m;
    static int[] combi;
    static List<Point_2nd> hList;
    static List<Point_2nd> pList;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {

            int wpdd = 0;

            for (Point_2nd h : hList) {
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

        Main_2nd T = new Main_2nd();
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
                    hList.add(new Point_2nd(i, j));
                }
                else if (a == 2) {
                    pList.add(new Point_2nd(i, j));
                }
            }
        }

        T.DFS(0, 0);

        System.out.println(answer);
    }
}
