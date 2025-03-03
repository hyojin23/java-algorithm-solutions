package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient {

    int order;
    int risk;

    Patient(int order, int risk) {
        this.order = order;
        this.risk = risk;
    }
}

public class Main {

    public int solution(int n, int m, int[] arr) {

        Queue<Patient> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            q.offer(new Patient(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Patient me = q.poll();
            boolean isReady = true;
            for (Patient other : q) {
                if (other.risk > me.risk) {
                    q.offer(me);
                    isReady = false;
                    break;
                }
            }
            if (isReady) {
                answer++;
                if (me.order == m) {
                    return answer;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
