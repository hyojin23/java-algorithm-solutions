package BOJ.BOJ2805;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public long getCutWoodTotal(int cutterHeight, int[] arr) {

        long sum = 0;
        for (int treeHeight : arr) {
            if (treeHeight > cutterHeight) {
                sum += treeHeight - cutterHeight;
            }
        }
        return sum;
    }

    public int solution(int N, int targetHeight, int[] arr) {

        int lt = 0;
        int rt = Arrays.stream(arr).max().getAsInt();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (getCutWoodTotal(mid, arr) >= targetHeight) {
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
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, M, arr));
    }
}
