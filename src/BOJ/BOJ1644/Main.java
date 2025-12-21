package BOJ.BOJ1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public int solution(int N) {

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        int lt = 0;
        int answer = 0;
        int sum = 0;

        for (int rt = 0; rt < list.size(); rt++) {
            sum += list.get(rt);
            while (sum > N) {
                sum -= list.get(lt);
                lt++;
            }
            if (sum == N) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(main.solution(N));
    }
}
