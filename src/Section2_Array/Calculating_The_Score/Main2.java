package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main2 {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int[] s = new int[n];
        for (int i=0; i<n; i++) {
            if (i == 0 && arr[i] == 1) {
                s[i] = 1;
            } else if (i != 0 && arr[i] == 1) {
                if (arr[i-1] == 0) {
                    s[i] = 1;
                } else {
                    s[i] = s[i-1] + 1;
                }
            }
        }
        for (int x : s) {
            answer += x;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i =0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
