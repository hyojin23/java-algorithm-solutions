package Section8_Use_DFS_BFS.Distance_Of_Pizza_Delivery;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m, hCnt, pCnt;
    static int[][] city;
    static List<Point> hList, pList;
    static int[] pIdx;
    int hMinDis, cMinDis;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {
            cMinDis = 0;
            for (Point h : hList) {
                hMinDis = Integer.MAX_VALUE;
                for (int i : pIdx) {
                    int dis = Math.abs(h.x - pList.get(i).x) + Math.abs(h.y - pList.get(i).y);
                    hMinDis = Math.min(hMinDis, dis);
                }
                cMinDis += hMinDis;
            }
            answer = Math.min(answer, cMinDis);
        }
        else {
            for (int i = s; i < pCnt; i++) {
                pIdx[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        city = new int[n + 1][n + 1];
        pIdx = new int[m];
        hList = new ArrayList<>();
        pList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int p = sc.nextInt();
                city[i][j] = p;

                if (p == 1) {
                    hList.add(new Point(i, j));
                }
                else if (p == 2) {
                    pList.add(new Point(i, j));
                }
            }
        }

        hCnt = hList.size();
        pCnt = pList.size();

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
