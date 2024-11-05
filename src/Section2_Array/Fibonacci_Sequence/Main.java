package Section2_Array.Fibonacci_Sequence;

import java.util.Scanner;

public class Main {

    public void solution(int n) {

        int a = 1;
        int b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
