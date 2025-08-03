package BOJ.BOJ11729;

import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    public void hanoi(int N, int from, int mid, int to) {

        if (N == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            return;
        }

        hanoi(N - 1, from, to, mid);
        sb.append(from).append(" ").append(to).append('\n');
        hanoi(N - 1, mid, from, to);
    }

    public void solution(int N) {

        sb = new StringBuilder();
        sb.append((int) Math.pow(2, N) - 1).append('\n');
        hanoi(N, 1, 2, 3);
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        T.solution(N);
        System.out.println(sb);
    }
}
