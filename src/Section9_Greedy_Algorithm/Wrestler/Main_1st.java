package Section9_Greedy_Algorithm.Wrestler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Wrestler_1st implements Comparable<Wrestler_1st>{

    int h, w;

    public Wrestler_1st(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Wrestler_1st w) {
        return w.h - this.h;
    }
}
public class Main_1st {

    public int solution(List<Wrestler_1st> wList) {

        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (Wrestler_1st w : wList) {
            if (w.w > max) {
                max = w.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Wrestler_1st> wList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Wrestler_1st w = new Wrestler_1st(sc.nextInt(), sc.nextInt());
            wList.add(w);
        }
        Collections.sort(wList);
        System.out.println(T.solution(wList));
    }
}
