package Section5_Stack_and_Queue.Emergency_Room;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Patient_5th {

    int rank;
    int danger;

    Patient_5th(int rank, int danger) {
        this.rank = rank;
        this.danger = danger;
    }
}

public class Main_5th {

    public int solution(int n, int m, int[] arr) {

        Queue<Patient_5th> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            q.offer(new Patient_5th(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Patient_5th p = q.poll();
            for (Patient_5th r : q) {
                if (r.danger > p.danger) {
                    q.offer(p);
                    break;
                }
            }
            if (!q.contains(p)) {
                answer++;
                if (p.rank == m) {
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
