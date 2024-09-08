package Section1_String.Reverse_The_Word;

import java.util.Scanner;

public class Main {
 
    public void solution(String[] arr) {
        for (String str : arr) {
            System.out.println(new StringBuilder(str).reverse());
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        T.solution(arr);
    }
}
