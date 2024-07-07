package Section2_Array.Rock_Paper_Scissors;

import java.util.Scanner;

public class Main_3rd {

    public void solution(int n, int[] a, int[] b) {

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) {
                System.out.println("D");
            }
            else {
                if (Math.abs(a[i] - b[i]) == 1) {
                    if (a[i] > b[i]) {
                        System.out.println("A");
                    }
                    else {
                        System.out.println("B");
                    }
                }
                else {
                    if (a[i] > b[i]) {
                        System.out.println("B");
                    }
                    else {
                        System.out.println("A");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        T.solution(n, a, b);
    }
}
