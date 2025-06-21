package BOJ.BOJ15686;

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

    static int N, M, cityMinChDis = Integer.MAX_VALUE;
    static List<Point> hsList;
    static List<Point> chList;
    static int[] combi;

    public void combi(int L, int s) {

        if (L == M) {
            int cityChDis = 0;
            for (Point hs : hsList) {
                int chDis = Integer.MAX_VALUE;
                for (int i : combi) {
                    int dis = Math.abs(hs.x - chList.get(i).x) + Math.abs(hs.y - chList.get(i).y);
                    chDis = Math.min(chDis, dis);
                }
                cityChDis += chDis;
            }
            cityMinChDis = Math.min(cityMinChDis, cityChDis);
        }
        else {
            for (int i = s; i < chList.size(); i++) {
                combi[L] = i;
                combi(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];
        hsList = new ArrayList<>();
        chList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    hsList.add(new Point(i, j));
                }
                if (a == 2) {
                    chList.add(new Point(i, j));
                }
            }
        }
        T.combi(0, 0);
        System.out.println(cityMinChDis);
    }
}
