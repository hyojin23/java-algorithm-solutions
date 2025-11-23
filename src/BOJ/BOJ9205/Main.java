package BOJ.BOJ9205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;
    char t;

    Point(int x, int y, char t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {

    static boolean[] visited;

    public String solution(List<Point> list) {

        Queue<Point> q = new LinkedList<>();
        Point s = list.get(0);
        visited[0] = true;
        q.offer(new Point(s.x, s.y, s.t));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.t == 'P') {
                return "happy";
            }
            for (int i = 0; i < list.size(); i++) {
                if (!visited[i]) {
                    Point next = list.get(i);
                    int dis = Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);
                    if (dis <= 1000) {
                        visited[i] = true;
                        q.offer(new Point(next.x, next.y, next.t));
                    }
                }
            }
        }
        return "sad";
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N + 2];
            List<Point> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x, y, 'S')); //상근이네 집

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());

                list.add(new Point(cx, cy, 'C'));   //편의점
            }

            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            list.add(new Point(px, py, 'P'));    //펜타포트 락 페스티벌
            System.out.println(main.solution(list));
        }
    }
}
