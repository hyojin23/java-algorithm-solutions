package BOJ.BOJ18870;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public void solution(int[] arr) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            set.add(x);
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int key : arr) {
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        T.solution(arr);
    }
}
