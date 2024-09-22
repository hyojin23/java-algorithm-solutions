package Section2_Array.Rock_Paper_Scissors;

import java.util.Scanner;

public class Main_4th {

    public void solution(int n, int[] a, int[] b) {

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) {
                System.out.println("D");
            }
            else {
                if (a[i] == 1 && b[i] == 3) {
                    System.out.println("A");
                }
                else if (a[i] == 2 && b[i] == 1) {
                    System.out.println("A");
                }
                else if (a[i] == 3 && b[i] == 2) {
                    System.out.println("A");
                }
                else {
                    System.out.println("B");
                }
            }
        }
    }


    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b= new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        T.solution(n, a, b);
    }
}