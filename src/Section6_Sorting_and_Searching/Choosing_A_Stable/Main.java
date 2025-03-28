package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int horseCnt(int mid, int[] arr) {
        int pos = arr[0];
        int cnt = 1;
        for (int x : arr) {
            if (x - pos >= mid) {
                pos = x;
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr) {

        Arrays.sort(arr);
        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (horseCnt(mid, arr) >= c) {
                lt = mid + 1;
                answer = mid;
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

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, c, arr));
    }
}
