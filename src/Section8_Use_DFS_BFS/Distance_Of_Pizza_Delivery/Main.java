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

    static List<Point> hsList, pzList;
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] combi;
    static int[][] city;

    public void DFS(int L, int s) {

        if (L == m) {
            int cityPzDis = 0;
            for (Point hs : hsList) {
                int pzDis = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    pzDis = Math.min(Math.abs(hs.x - pzList.get(combi[i]).x) + Math.abs(hs.y - pzList.get(combi[i]).y), pzDis);
                }
                cityPzDis += pzDis;
            }
            answer = Math.min(cityPzDis, answer);
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
        city = new int[n][n];
        combi = new int[m];
        hsList = new ArrayList<>();
        pzList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    hsList.add(new Point(i, j));
                }
                if (city[i][j] == 2) {
                    pzList.add(new Point(i, j));
                }
            }
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
