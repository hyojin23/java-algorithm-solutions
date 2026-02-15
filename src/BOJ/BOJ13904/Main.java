package BOJ.BOJ13904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Task implements Comparable<Task> {

    int d, w;

    Task(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Task ob) {
        return Integer.compare(ob.w, this.w);
    }
}

public class Main {

    static int[] parent;

    public static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        else {
            return parent[v] = find(parent[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        parent[fa] = fb;
    }

    public static int solution(int N, int maxDay, List<Task> tasks) {

        Collections.sort(tasks);
        int[] answer = new int[maxDay + 1];
        parent = new int[maxDay + 1];

        for (int i = 1; i <= maxDay; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int available = find(tasks.get(i).d);
            if (available != 0) {
                answer[available] = tasks.get(i).w;
                union(available, available - 1);
            }
        }

        int sum = 0;
        for (int x : answer) {
            sum += x;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        List<Task> tasks = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, d);
            tasks.add(new Task(d, w));
        }

        System.out.println(solution(N, maxDay, tasks));
    }
}
