package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main_7th {

    public int horseArngCnt(int dis, int[] arr) {

        int lastHorsePos = arr[0];
        int cnt = 1;
        for (int x : arr) {
            if (x >= lastHorsePos + dis) {
                cnt++;
                lastHorsePos = x;
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
            if (horseArngCnt(mid, arr) >= c) {
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

        Main_7th T = new Main_7th();
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
