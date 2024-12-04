package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient {

    int order, danger;

    Patient(int order, int danger) {
        this.order = order;
        this.danger = danger;
    }
}

public class Main {

    public int solution(int n, int m, Queue<Patient> q) {

        int cnt = 0;
        while (!q.isEmpty()) {
            Patient p = q.poll();
            for (Patient other : q) {
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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Patient> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int danger = sc.nextInt();
            q.offer(new Patient(i, danger));
        }

        System.out.println(T.solution(n, m, q));
    }
}
