package BOJ.BOJ15686;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point_1st {

    int x, y;

    Point_1st(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_1st {

    static int N, M, cityMinChDis = Integer.MAX_VALUE;
    static List<Point_1st> hsList;
    static List<Point_1st> chList;
    static int[] combi;

    public void combi(int L, int s) {

        if (L == M) {
            int cityChDis = 0;
            for (Point_1st hs : hsList) {
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

        Main_1st T = new Main_1st();
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
                    hsList.add(new Point_1st(i, j));
                }
                if (a == 2) {
                    chList.add(new Point_1st(i, j));
                }
            }
        }
        T.combi(0, 0);
        System.out.println(cityMinChDis);
    }
}
