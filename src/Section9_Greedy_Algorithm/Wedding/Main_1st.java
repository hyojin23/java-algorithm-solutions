package Section9_Greedy_Algorithm.Wedding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Friend_1st implements Comparable<Friend_1st>{

    int time;
    char state;

    public Friend_1st(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Friend_1st f) {
        if (this.time == f.time) {
            return this.state - f.state;
        }
        else {
            return this.time - f.time;
        }
    }
}
public class Main_1st {

    public int solution(List<Friend_1st> list) {

        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        Collections.sort(list);

        for (Friend_1st f : list) {
            if (f.state == 's') {
                cnt++;
            }
            else if (f.state == 'e') {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Friend_1st> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Friend_1st(s, 's'));
            list.add(new Friend_1st(e, 'e'));
        }
        System.out.println(T.solution(list));
    }
}
