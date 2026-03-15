package BOJ.BOJ15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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

    static int N, M, answer = Integer.MAX_VALUE;
    static List<Point> hsList, chcknList;
    static int[] combi;

    public static void combination(int s, int L) {

        if (L == M) {
            int cityCkDis = 0;
            for (Point hs : hsList) {
                int ckDis = Integer.MAX_VALUE;
                for (int i = 0; i < M; i++) {
                    Point ck = chcknList.get(combi[i]);
                    ckDis = Math.min(ckDis, Math.abs(hs.x - ck.x) + Math.abs(hs.y - ck.y));
                }
                cityCkDis += ckDis;
            }
            answer = Math.min(answer, cityCkDis);
        }
        else {
            for (int i = s; i < chcknList.size(); i++) {
                combi[L] = i;
                combination(i + 1, L + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] city = new int[N][N];

        hsList = new ArrayList<>();
        chcknList = new ArrayList<>();
        combi = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    hsList.add(new Point(i, j));
                }
                else if (city[i][j] == 2) {
                    chcknList.add(new Point(i, j));
                }
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }
}
