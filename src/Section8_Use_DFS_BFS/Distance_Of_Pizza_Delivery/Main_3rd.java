package Section8_Use_DFS_BFS.Distance_Of_Pizza_Delivery;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Point_3rd {

    int x, y;

    Point_3rd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_3rd {

    static int n, m;
    static int[][] city;
    static List<Point_3rd> hsList;
    static List<Point_3rd> pzList;
    static int[] combi;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int s) {

        if (L == m) {
            int cityDis = 0;

            for (Point_3rd h : hsList) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    Point_3rd pz = pzList.get(i);
                    dis = Math.min(dis, Math.abs(h.x - pz.x) + Math.abs(h.y - pz.y));
                }

                cityDis += dis;
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

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        city = new int[n + 1][n + 1];

        hsList = new ArrayList<>();
        pzList = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                int a = sc.nextInt();

                if (a == 1) {
                    hsList.add(new Point_3rd(i, j));
                }
                else if (a == 2) {
                    pzList.add(new Point_3rd(i, j));
                }
                city[i][j] = a;
            }
        }

        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
