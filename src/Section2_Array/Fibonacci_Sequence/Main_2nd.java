package Section2_Array.Fibonacci_Sequence;

import java.util.Scanner;

public class Main_2nd {

    public void solution(int n) {

        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
