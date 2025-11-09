package BOJ.BOJ1744;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public int solution(List<Integer> numsAboveOne, List<Integer> ones, List<Integer> numsZeroOrLess) {

        Collections.sort(numsAboveOne, Collections.reverseOrder());
        Collections.sort(numsZeroOrLess);

        int sum1 = 0;
        int target1 = 0;
        for (int i = 0; i < numsAboveOne.size(); i++) {
            if (i % 2 == 0) {
                target1 = numsAboveOne.get(i);
                if (i == numsAboveOne.size() - 1) {
                    sum1 += target1;
                }
            }
            else {
                sum1 += target1 * numsAboveOne.get(i);
            }
        }

        int sum2 = 0;
        for (int x : ones) {
            sum2 += x;
        }

        int sum3 = 0;
        int target3 = 0;
        for (int i = 0; i < numsZeroOrLess.size(); i++) {
            if (i % 2 == 0) {
                target3 = numsZeroOrLess.get(i);
                if (i == numsZeroOrLess.size() - 1) {
                    sum3 += target3;
                }
            }
            else {
                sum3 += target3 * numsZeroOrLess.get(i);
            }
        }

        return sum1 + sum2 + sum3;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numsAboveOne = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<Integer> numsZeroOrLess = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                numsAboveOne.add(num);
            }
            else if (num == 1) {
                ones.add(num);
            }
            else {
                numsZeroOrLess.add(num);
            }
        }
        System.out.println(T.solution(numsAboveOne, ones, numsZeroOrLess));
    }
}
