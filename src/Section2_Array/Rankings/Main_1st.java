package Section2_Array.Rankings;

import java.util.Scanner;

public class Main_1st {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int tmp = 0;
            for (int j=0; j<n; j++) {
                if (arr[i] < arr[j]) {
                    tmp++;
                }
            }
            answer[i] = tmp + 1;
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
