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
    static int n, m;
    static int[] combi;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {
            int cityDis = 0;
            for (Point hs : hsList) {
                int hsDis = Integer.MAX_VALUE;
                for (int x : combi) {
                    hsDis = Math.min(hsDis, Math.abs(hs.x - pzList.get(x).x) + Math.abs(hs.y - pzList.get(x).y));
                }
                cityDis += hsDis;
            }
            answer = Math.min(answer, cityDis);
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
        combi = new int[m];
        hsList = new ArrayList<>();
        pzList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    hsList.add(new Point(i, j));
                }
                if (a == 2) {
                    pzList.add(new Point(i, j));
                }
            }
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
