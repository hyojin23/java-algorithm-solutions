package BOJ.BOJ2109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Lecture implements Comparable<Lecture> {

    int p, d;

    Lecture(int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Lecture ob) {
        return Integer.compare(ob.d, this.d);
    }
}

public class Main {

    public static int solution(int N, List<Lecture> lectures, int maxDay) {

        Collections.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int answer = 0;
        for (int d = maxDay; d >= 1; d--) {
            for ( ; i < N; i++) {
                if (lectures.get(i).d >= d) {
                    pq.offer(lectures.get(i).p);
                }
                else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();

        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
            maxDay = Math.max(maxDay, d);
        }

        System.out.println(solution(N, lectures, maxDay));
    }
}
