package Section3_Two_Pointers_and_Sliding_Window.Continuous_Partial_Sequence;

import java.util.Scanner;
// My solution
public class Main2 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int p = 0, c = 0, sum = 0;
        while (p<n) {
            sum += arr[p++];
            if (sum == m) {
                answer++;
                sum = 0;
                c++;
                p = c;
            }
            if (sum > m) {
                sum = 0;
                c++;
                p = c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
