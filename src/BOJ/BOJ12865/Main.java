package BOJ.BOJ12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Item {

    int w, v;

    Item(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {

    public static int solution(int K, List<Item> items) {

        int[] dp = new int[K + 1];

        for (Item item : items) {
            for (int i = K; i >= item.w; i--) {
                dp[i] = Math.max(dp[i], dp[i - item.w] + item.v);
            }
        }

        return dp[K];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            items.add(new Item(w, v));
        }

        System.out.println(solution(K, items));
    }
}
