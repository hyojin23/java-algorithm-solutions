package BOJ.BOJ2473;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public void solution(int N, long[] arr) {

        Arrays.sort(arr);
        long[] answer = new long[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int lt = i + 1;
            int rt = N - 1;
            while (lt < rt) {
                long sum = arr[i] + arr[lt] + arr[rt];

                if (sum == 0) {
                    System.out.println(arr[i] + " " + arr[lt] + " " + arr[rt]);
                    return;
                }

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[lt];
                    answer[2] = arr[rt];
                }

                if (sum > 0) {
                    rt--;
                }
                else {
                    lt++;
                }
            }
        }
        for (long x : answer) {
            System.out.print(x + " ");
        }
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        main.solution(N, arr);
    }
}
