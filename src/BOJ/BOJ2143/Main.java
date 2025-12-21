package BOJ.BOJ2143;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public long solution(long T, int n, int m, int[] A, int[] B) {

        //A배열의 부분연속배열
        List<Long> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        //B배열의 부분연속배열
        List<Long> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        //sumB배열 정렬 후 T - a를 이분검색으로 찾음
        Collections.sort(sumB);
        long answer = 0;
        for (long a : sumA) {
            long target = T - a;
            int lowerBound = lowerBound(sumB, target);
            int upperBound = upperBound(sumB, target);
            answer += upperBound - lowerBound;
        }
        return answer;
    }

    public int lowerBound(List<Long> list, long target) {
        int lt = 0;
        int rt = list.size();
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (list.get(mid) < target) {
                lt = mid + 1;
            }
            else {
                rt = mid;
            }
        }
        return lt;
    }

    public int upperBound(List<Long> list, long target) {
        int lt = 0;
        int rt = list.size();
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (list.get(mid) <= target) {
                lt = mid + 1;
            }
            else {
                rt = mid;
            }
        }
        return lt;
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(T, n, m, A, B));
    }
}
