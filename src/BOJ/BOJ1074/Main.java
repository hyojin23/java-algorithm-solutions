package BOJ.BOJ1074;

import java.util.Scanner;

public class Main {

    static int N, r, c, cnt;

    public void count(int size, int r, int c) {

        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int n = size / 2;
        if (r < n && c < n) {
            cnt += n * n * 0;
            count(n, r, c);
        }
        else if (r < n && c < size) {
            cnt += n * n * 1;
            count(n, r, c - n);
        }
        else if (r < size && c < n) {
            cnt += n * n * 2;
            count(n, r - n, c);
        }
        else {
            cnt += n * n * 3;
            count(n, r - n, c - n);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        T.count((int) Math.pow(2, N), r, c);
    }
}
