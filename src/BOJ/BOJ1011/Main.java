package BOJ.BOJ1011;

import java.util.Scanner;

public class Main {

    public int solution(int x, int y) {

        int d = y - x;
        int n = (int) Math.sqrt(d);
        if (d == n * n) {
            return 2 * n - 1;
        }
        else if (d <= n * n + n) {
            return 2 * n;
        }
        else {
            return 2 * n + 1;
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(main.solution(x, y));
        }
    }
}
