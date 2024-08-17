package Section9_Greedy_Algorithm.Wrestler;

import java.util.*;


class Wrestler_3rd implements Comparable<Wrestler_3rd> {

    int h, w;

    public Wrestler_3rd(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Wrestler_3rd o) {
        return o.h - this.h;
    }
}

public class Main_3rd {

    public int solution(List<Wrestler_3rd> list) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Wrestler_3rd w : list) {

            if (w.w > max) {
                answer++;
            }
            max = Math.max(max, w.w);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Wrestler_3rd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Wrestler_3rd(h, w));
        }

        System.out.println(T.solution(list));
    }
}
