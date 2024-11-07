package Section4_HashMap_and_TreeSet.Kth_Largest_Number;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

public class Main_5th {

    public int solution(int n, int k, int[] arr) {

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int answer = -1;

        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 1;
        //set.remove(143);
        //System.out.println(set.size());
        //System.out.println(set.last());
        for (int x : set) {
            if (cnt == k) {
                answer = x;
            }
            cnt++;
        }

        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
