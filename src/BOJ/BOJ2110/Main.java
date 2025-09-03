package BOJ.BOJ2110;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public boolean isPossible(int dis, int targetCount, int[] arr) {

        int lastInstalled = arr[0];
        int installCount = 1;
        for (int pos : arr) {
            if (pos >= lastInstalled + dis) {
                lastInstalled = pos;
                installCount++;
            }
        }
        return installCount >= targetCount;
    }

    public int solution(int N, int C, int[] arr) {

        int lt = 1;
        int rt = arr[N - 1] - arr[0];
        int answer = 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (isPossible(mid, C, arr)) {
                answer = mid;
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(T.solution(N, C, arr));
    }
}
