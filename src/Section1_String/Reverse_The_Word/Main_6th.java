package Section1_String.Reverse_The_Word;

import java.util.Scanner;

public class Main_6th {

    public void solution(int n, String[] arr) {

        for (String str : arr) {
            for (int i = str.length() - 1; i >= 0; i--) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        T.solution(n, arr);
    }
}
