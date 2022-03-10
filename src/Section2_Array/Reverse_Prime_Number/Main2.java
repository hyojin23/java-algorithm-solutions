package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;

public class Main2 {

    public void solution (int n, String str) {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int len = arr[i].length();
            int a = Integer.parseInt(sb.append(arr[i]).reverse().toString());
            sb.delete(0, len);

            boolean isPrime = true;
            for (int j=2; j<a; j++) {
                if (a % j == 0) {
                    // a is not prime
                    isPrime = false;
                    break;
                }
            }
            if (a == 1) {
                isPrime = false;
            }
            if (isPrime) {
                System.out.print(a + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        T.solution(n, str);
    }
}
