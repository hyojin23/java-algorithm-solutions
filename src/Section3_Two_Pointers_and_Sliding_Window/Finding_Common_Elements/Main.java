package Section3_Two_Pointers_and_Sliding_Window.Finding_Common_Elements;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    public List<Integer> solution(int[] a, int[] b, int n, int m) {

        int p1 = 0, p2 = 0;
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                p1++;
            }
            else if (b[p2] < a[p1]) {
                p2++;
            }
            else {
                answer.add(a[p1]);
                p1++;
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b= new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        for (int x : T.solution(a, b, n, m)) {
            System.out.print(x + " ");
        }

    }
}
