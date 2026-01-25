package BOJ.BOJ1781;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Problem implements Comparable<Problem>{

    int d, r;

    Problem(int d, int r) {
        this.d = d;
        this.r = r;
    }

    @Override
    public int compareTo(Problem ob) {
        return Integer.compare(ob.d, this.d);
    }
}

public class Main {

    public static int solution(int N, List<Problem> list) {

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int maxD = 0;
        for (Problem p : list) {
            maxD = Math.max(maxD, p.d);
        }

        int sum = 0;
        int i = 0;
        for (int time = maxD; time >= 1; time--) {
            for (; i < N; i++) {
                if (list.get(i).d >= time) {
                    pq.offer(list.get(i).r);
                }
                else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();

            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Problem> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int d = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            list.add(new Problem(d, r));
        }

        System.out.println(solution(N, list));
    }
}
