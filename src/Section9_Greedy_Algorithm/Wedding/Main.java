package Section9_Greedy_Algorithm.Wedding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Friend implements Comparable<Friend>{

    int time;
    char state;

    public Friend(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Friend f) {
        if (this.time == f.time) {
            return this.state - f.state;
        }
        else {
            return this.time - f.time;
        }
    }
}
public class Main {

    public int solution(List<Friend> list) {

        int answer = Integer.MIN_VALUE;
        int cnt = 0;

        Collections.sort(list);

        for (Friend f : list) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Friend> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Friend(s, 's'));
            list.add(new Friend(e, 'e'));
        }
        System.out.println(T.solution(list));
    }
}
