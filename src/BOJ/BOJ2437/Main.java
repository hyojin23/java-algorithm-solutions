package BOJ.BOJ2437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static int solution(int[] weights) {

        Arrays.sort(weights);

        int s = 0;
        for (int w : weights) {
            if (w > s + 1) {
                return s + 1;
            }
            s = s + w;
        }
        return s + 1;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(weights));
    }
}
