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

    static int n, m;
    static List<Point> hsList, pzList;
    static int[] combi;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {
            int cityMinDis = 0;
            for (Point hs : hsList) {
                int min = Integer.MAX_VALUE;
                for (int x : combi) {
                    int dis = Math.abs(hs.x - pzList.get(x).x) + Math.abs(hs.y - pzList.get(x).y);
                    min = Math.min(min, dis);
                }
                cityMinDis += min;
            }
            answer = Math.min(answer, cityMinDis);
        }
        else {
            for (int i = s; i < pzList.size(); i++) {
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
        int[][] city = new int[n + 1][n + 1];
        hsList = new ArrayList<>();
        pzList = new ArrayList<>();
        combi = new int[m];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    hsList.add(new Point(i, j));
                }
                else if (city[i][j] == 2) {
                    pzList.add(new Point(i, j));
                }
            }
        }

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
