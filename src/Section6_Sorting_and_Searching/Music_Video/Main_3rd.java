package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;
import java.util.Arrays;

public class Main_3rd {

    public int solution(int n, int m, int[] arr) {

        int cnt;
        int cpct;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while (lt <= rt) {

            cnt = 1;
            cpct = 0;
            int mid = (lt + rt) / 2;

            for (int i = 0; i < n; i++) {
                cpct += arr[i];

                if (cpct > mid) {
                    cnt++;
                    cpct = 0;
                    i--;
                }
            }

            if (cnt > m) {
                lt = mid + 1;
            }
            else {
                answer = mid;
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
