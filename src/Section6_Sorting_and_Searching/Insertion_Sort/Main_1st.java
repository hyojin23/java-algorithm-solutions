package Section6_Sorting_and_Searching.Insertion_Sort;

import java.util.Scanner;

public class Main_1st {

    public int[] solution(int n, int[] answer) {
        for (int i=1; i<n; i++) {
            int tmp = answer[i], j;
            for (j=i-1; j>=0; j--) {
                if (answer[j] > tmp) {
                    answer[j+1] = answer[j];
                } else {
                    break;
                }
            }
            answer[j+1] = tmp;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_1st T = new Main_1st();
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
