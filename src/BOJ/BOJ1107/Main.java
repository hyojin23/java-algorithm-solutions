package BOJ.BOJ1107;

import java.util.Scanner;

public class Main {

    static final int NOW_CHANNEL = 100;
    static boolean[] broken;

    public boolean isPossible(int n) {

        if (n == 0) {
            return !broken[0];
        }
        while (n > 0) {
            if (broken[n % 10]) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public int solution(int N, int M) {

        int answer = Math.abs(N - NOW_CHANNEL);
        for (int i = 0; i <= 999_999; i++) {
            if (isPossible(i)) {
                int press = String.valueOf(i).length() + Math.abs(N - i);
                answer = Math.min(answer, press);
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        broken = new boolean[10];
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        System.out.println(T.solution(N, M));
    }
}
