package BOJ.BOJ2343;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public boolean canMakeBluRay (int bluRayTime, int bluRayCnt, int[] arr) {

        int sum = 0;
        int cnt = 1;
        for (int videoTime : arr) {
            if (sum + videoTime > bluRayTime) {
                cnt++;
                sum = videoTime;
            }
            else {
                sum += videoTime;
            }
        }
        return cnt <= bluRayCnt;
    }

    public int solution(int M, int maxTime, int sumTime, int[] arr) {

        int lt = maxTime;
        int rt = sumTime;
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (canMakeBluRay(mid, M, arr)) {
                answer = mid;
                rt = mid - 1;
            }
            else {
                lt = mid + 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st =  new StringTokenizer(br.readLine());

        int sumTime = 0;
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxTime = Math.max(maxTime, arr[i]);
            sumTime += arr[i];
        }
        System.out.println(T.solution(M, maxTime, sumTime, arr));
    }
}
