package Recommended_Problems.Stack_Deque.BOJ2812;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    public String solution(int N, int K, String num) {

        char[] numArr = num.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (K > 0 && !dq.isEmpty() && dq.getLast() < numArr[i]) {
                dq.removeLast();
                K--;
            }
            dq.addLast(numArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (dq.size() > K) {
            sb.append(dq.removeFirst());
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();
        System.out.println(T.solution(N, K, num));
    }
}
