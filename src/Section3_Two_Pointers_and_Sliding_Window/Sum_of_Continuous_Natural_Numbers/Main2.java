package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;
// My solution
public class Main2 {

    public int solution(int n) {
        int answer = 0;
        int lt = 0, rt = 0, sum = 0;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        while (lt<+(n/2)) {
            if (sum == n) {
                answer++;
                sum -= arr[lt++];
            } else if (sum < n) {
                sum += arr[rt++];
            } else {
                sum -= arr[lt++];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
