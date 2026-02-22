package BOJ.BOJ2457;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Flower implements Comparable<Flower> {

    int s, e;

    Flower(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Flower ob) {
        if (this.s == ob.s) {
            return Integer.compare(ob.e, this.e);
        }
        return Integer.compare(this.s, ob.s);
    }
}

public class Main {

    public static int solution(int N, List<Flower> flowers) {

        Collections.sort(flowers);

        int cur = 301;
        int i = 0;
        int cnt = 0;
        while (cur <= 1130) {

            int max = cur;

            while (i < N && flowers.get(i).s <= cur) {
                max = Math.max(max, flowers.get(i).e);
                i++;
            }

            if (max == cur) {
                return 0;
            }

            cnt++;
            cur = max;
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int s = sm * 100 + sd;
            int e = em * 100 + ed;

            flowers.add(new Flower(s, e));
        }

        System.out.println(solution(N, flowers));
    }
}
