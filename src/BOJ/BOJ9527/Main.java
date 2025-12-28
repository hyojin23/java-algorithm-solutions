package BOJ.BOJ9527;

import java.util.Scanner;

public class Main {

    //0부터 N까지의 1의 개수를 구함
    public static long countOne(long N) {

        long sumOneCount = 0;
        int len = Long.toBinaryString(N).length();

        for (int i = 0; i < len; i++) {
            long totalCount = N + 1;
            long cycleCount = totalCount / (1L << (i + 1));
            long mainOneCount = cycleCount * (1L << i);

            long remainder = totalCount % (1L << i + 1);
            long remainderOneCount = Math.max(0, remainder - (1L << i));

            sumOneCount += (mainOneCount + remainderOneCount);
        }
        return sumOneCount;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long answer = countOne(B) - countOne(A - 1);

        System.out.println(answer);
    }
}
