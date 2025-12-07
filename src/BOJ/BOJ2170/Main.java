package BOJ.BOJ2170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {

    int s, e;

    Edge(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Edge ob) {
        if (this.s == ob.s) {
            return this.e - ob.e;
        }
        else {
            return this.s - ob.s;
        }
    }
}

public class Main {

    public int solution(List<Edge> list) {

        Collections.sort(list);
        int answer = 0;
        int start = list.get(0).s;
        int end = list.get(0).e;

        for (int i = 1; i < list.size(); i++) {
            int ns = list.get(i).s;
            int ne = list.get(i).e;
            if (ns <= end) {
                if (ne > end) {
                    end = list.get(i).e;
                }
            }
            else {
                answer += end - start;
                start = list.get(i).s;
                end = list.get(i).e;
            }
        }
        answer += end - start;

        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Edge> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Edge(s, e));
        }
        System.out.println(T.solution(list));
    }
}
