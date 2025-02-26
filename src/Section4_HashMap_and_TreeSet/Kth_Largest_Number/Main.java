package Section4_HashMap_and_TreeSet.Kth_Largest_Number;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

public class Main {

    public int solution(int n, int k, int[] arr) {

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int answer = -1;
        int order = 1;
        //tSet.remove(143);
        //System.out.println(tSet.size());
        //System.out.println("first : " + tSet.first());
        //System.out.println("last : " + tSet.last());

        for (int x : tSet) {
            System.out.println(x);
            if (order == k) {
                answer = x;
                break;
            }
            order++;
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
