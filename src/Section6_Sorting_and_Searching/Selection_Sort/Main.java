package Section6_Sorting_and_Searching.Selection_Sort;

import java.util.Scanner;

public class Main {

    public int[] solution(int n, int[] answer) {
        for (int i=0; i<n-1; i++) {
            int idx = i;
            for (int j=i+1; j<n; j++) {
                if (answer[j] < answer[idx]) {
                    idx = j;
                }
            }
            int tmp = answer[i];
            answer[i] = answer[idx];
            answer[idx] = tmp;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
