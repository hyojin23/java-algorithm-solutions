package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient_6th {

    int order;
    int danger;

    Patient_6th(int order, int danger) {
        this.order = order;
        this.danger = danger;
    }
}

public class Main_6th {

    public int solution(int n, int m, Queue<Patient_6th> q) {

        int answer = 0;
        while (!q.isEmpty()) {
            Patient_6th me = q.poll();
            boolean notMyTurn = false;
            for (Patient_6th other : q) {
                if (other.danger > me.danger) {
                    notMyTurn = true;
                    break;
                }
            }
            if (notMyTurn) {
                q.offer(me);
            }
            else {
                answer++;
                if (me.order == m) {
                    return answer;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Patient_6th> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int danger = sc.nextInt();
            q.offer(new Patient_6th(i, danger));
        }

        System.out.println(T.solution(n, m, q));
    }
}
