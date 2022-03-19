package Section6_Sorting_and_Searching.Selection_Sort;

import java.util.Scanner;
// My solution
public class Main2 {

    public int[] solution(int n, int[] answer) {
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (answer[i] > answer[j]) {
                    int tmp = answer[j];
                    answer[j] = answer[i];
                    answer[i] = tmp;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
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
