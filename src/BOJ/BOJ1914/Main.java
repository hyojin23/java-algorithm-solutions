package BOJ.BOJ1914;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void hanoi(int N, int from, int to, int via) {

        if (N == 1) {
            System.out.println(from + " " + to);
            return;
        }

        hanoi(N - 1, from, via, to);
        System.out.println(from + " " + to);
        hanoi(N - 1, via, to, from);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        BigInteger moves = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (N <= 20) {
            hanoi(N, 1, 3, 2);
        }
    }
}
