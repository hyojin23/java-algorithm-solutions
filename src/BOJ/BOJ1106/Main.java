package BOJ.BOJ1106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Info {
    int c, p;

    Info(int c, int p) {
        this.c = c;
        this.p = p;
    }
}

public class Main {

    public int solution(int C, List<Info> list) {

        int INF = 1000_000_000;
        int[] dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (Info info : list) {
            for (int i = info.p; i <= C + 100; i++) {
                dp[i] = Math.min(dp[i], dp[i - info.p] + info.c);
            }
        }

        int answer = INF;
        for (int i = C; i <= C + 100; i++) {
            answer = Math.min(dp[i], answer);
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Info(c, p));
        }
        System.out.println(main.solution(C, list));
    }
}
