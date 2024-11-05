package Section2_Array.Rock_Paper_Scissors;

import java.util.Scanner;

public class Main {

    public void solution(int n, int[] arr1, int[] arr2) {

        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) {
                System.out.println("D");
            }
            else if (arr1[i] == 1 && arr2[i] == 3) {
                System.out.println("A");
            }
            else if (arr1[i] == 2 && arr2[i] == 1) {
                System.out.println("A");
            }
            else if (arr1[i] == 3 && arr2[i] == 2) {
                System.out.println("A");
            }
            else {
                System.out.println("B");
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        T.solution(n, arr1, arr2);
    }
}
