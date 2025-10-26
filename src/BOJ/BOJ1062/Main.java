package BOJ.BOJ1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static final int BASE_MASK = getMask("antic");
    static int[] words;
    static int maxRead = 0;

    public static int getMask(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask = mask | 1 << (c - 'a');
        }
        return mask;
    }

    public void DFS(int start, int depth, int limit, int learnedMask) {

        if (depth == limit) {
            int count = 0;
            for (int wordMask : words) {
                if ((learnedMask & wordMask) == wordMask) {
                    count++;
                }
            }
            maxRead = Math.max(maxRead, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((BASE_MASK & (1 << i)) != 0) {
                continue;
            }
            DFS(i + 1, depth + 1, limit, learnedMask | (1 << i));
        }
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine().trim();
            words[i] = getMask(word);
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }
        T.DFS(0, 0, K - 5, BASE_MASK);
        System.out.println(maxRead);
    }
}
