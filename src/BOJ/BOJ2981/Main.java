package BOJ.BOJ2981;

import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public String solution(int N, int[] arr) {

        Arrays.sort(arr);
        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        int g = diff[0];
        for (int i = 1; i < N - 1; i++) {
            g = gcd(g, diff[i]);
        }

        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 2; i * i <= g; i++) {
            if (g % i == 0) {
                ts.add(i);
                ts.add(g / i);
            }
        }
        ts.add(g);

        for (int x : ts) {
            sb.append(x).append(" ");
        }
        return sb.toString().trim();
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, arr));
    }
}
