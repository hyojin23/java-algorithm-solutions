package BOJ.BOJ7662;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Main {

    public String solution(int k, char[] cmd, int[] num) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (cmd[i] == 'I') {
                minHeap.offer(num[i]);
                maxHeap.offer(num[i]);
                countMap.put(num[i], countMap.getOrDefault(num[i], 0) + 1);
            }
            else if (cmd[i] == 'D') {
                if (num[i] == 1) {
                    remove(maxHeap, countMap);
                }
                else {
                    remove(minHeap, countMap);
                }
            }
        }

        if (countMap.isEmpty()) {
            return "EMPTY";
        }
        else {
            int max = getValid(maxHeap, countMap);
            int min = getValid(minHeap, countMap);
            return max + " " + min;
        }
    }

    public void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {

        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (countMap.containsKey(val)) {
                countMap.put(val, countMap.get(val) - 1);
                if (countMap.get(val) == 0) {
                    countMap.remove(val);
                }
                break;
            }
        }
    }

    public int getValid(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {

        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (countMap.containsKey(val)) {
                return val;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            char[] cmd = new char[k];
            int[] num = new int[k];
            for (int j = 0; j < k; j++) {
                cmd[j] = sc.next().charAt(0);
                num[j] = sc.nextInt();
            }
            System.out.println(main.solution(k, cmd, num));
        }
    }
}
