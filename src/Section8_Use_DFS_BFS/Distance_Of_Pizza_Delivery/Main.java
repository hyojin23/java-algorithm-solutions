package Section8_Use_DFS_BFS.Distance_Of_Pizza_Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static List<Point> hsList, pzList, selectList;
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    public void DFS(int L, int s) {

        if (L == m)  {
            int sum = 0;
            for (Point h : hsList) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pzList.get(i).x) + Math.abs(h.y - pzList.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = s; i < len; i++) {
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
        int[][] arr = new int[n + 1][n + 1];

        hsList = new ArrayList<>();
        pzList = new ArrayList<>();
        selectList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                arr[i][j] = a;

                if (a == 1)
                    hsList.add(new Point(i, j));
                else if (a == 2)
                    pzList.add(new Point(i, j));
            }
        }
        len = pzList.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
