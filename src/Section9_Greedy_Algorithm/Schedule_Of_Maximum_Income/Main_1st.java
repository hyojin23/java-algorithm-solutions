package Section9_Greedy_Algorithm.Schedule_Of_Maximum_Income;

import java.util.*;

class Lecture_1st implements Comparable<Lecture_1st> {

    int m, t;

    public Lecture_1st(int m, int t) {
        this.m = m;
        this.t = t;
    }

    @Override
    public int compareTo(Lecture_1st l) {
        return l.t - this.t;
    }
}
public class Main_1st {

    int answer = 0;
    static int max = Integer.MIN_VALUE;
    static int n;
    public int solution(List<Lecture_1st> list) {

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).t < i) break;
                pQ.offer(list.get(j).m);
            }
            if (!pQ.isEmpty())
                answer += pQ.poll();
        }
        return answer;
    }
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        List<Lecture_1st> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int m = sc.nextInt();
            int t = sc.nextInt();

            list.add(new Lecture_1st(m, t));

            if (t > max) max = t;
        }

        System.out.println(T.solution(list));
    }
}
