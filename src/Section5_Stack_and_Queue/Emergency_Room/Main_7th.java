package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient_7th {

    int order, danger;

    Patient_7th(int order, int danger) {
        this.order = order;
        this.danger = danger;
    }
}

public class Main_7th {

    public int solution(int n, int m, Queue<Patient_7th> q) {

        int cnt = 0;
        while (!q.isEmpty()) {
            Patient_7th p = q.poll();
            for (Patient_7th other : q) {
                if (other.danger > p.danger) {
                    q.offer(p);
                    break;
                }
            }
            if (!q.contains(p)) {
                cnt++;
                if (p.order == m) {
                    return cnt;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Patient_7th> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int danger = sc.nextInt();
            q.offer(new Patient_7th(i, danger));
        }

        System.out.println(T.solution(n, m, q));
    }
}
