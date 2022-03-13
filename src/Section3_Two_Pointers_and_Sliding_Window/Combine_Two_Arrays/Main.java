package Section3_Two_Pointers_and_Sliding_Window.Combine_Two_Arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public ArrayList<Integer> solution(int n, int[] narr, int m, int[] marr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int np = 0, mp = 0;
        while (np<n && mp<m) {
            if (narr[np]<marr[mp]) {
                answer.add(narr[np++]);
            } else {
                answer.add(marr[mp++]);
            }
        }
        while (np<n) {
            answer.add(narr[np++]);
        }
        while (mp<m) {
        answer.add(marr[mp++]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] narr = new int[n];
        for (int i=0; i<n; i++) {
            narr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] marr = new int[m];
        for (int i=0; i<m; i++) {
            marr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, narr, m, marr)) {
            System.out.print(x + " ");
        }
    }
}
