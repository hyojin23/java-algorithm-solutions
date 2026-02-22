package BOJ.BOJ17825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] next, score, blue, horse, dices;
    static int max;
    static final int END = 32;

    public static int solution() {

        next = new int[33];
        score = new int[33];
        blue = new int[33];

        setNext(next);
        setScore(score);
        setBlue(blue);

        max = Integer.MIN_VALUE;
        horse = new int[4];
        dfs(0, 0);

        return max;
    }

    public static void dfs(int turn, int scoreSum) {

        if (turn == 10) {
            max = Math.max(max, scoreSum);
        }
        else {
            for (int i = 0; i < 4; i++) {
                int curPos = horse[i];
                if (curPos == END) {        //도착한 말은 이동 X
                    continue;
                }

                int nextPos = move(curPos, dices[turn]);
                if (isOverlap(nextPos, i)) {   //이동하려는 위치에 말이 있으면 이동 X
                    continue;
                }

                horse[i] = nextPos;
                dfs(turn + 1, scoreSum + score[nextPos]);
                horse[i] = curPos;
            }
        }
    }

    public static boolean isOverlap(int pos, int idx) {

        if (pos == END) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (i == idx) continue;
            if (horse[i] == pos) {
                return true;
            }
        }
        return false;
    }

    public static void setNext(int[] next) {
        for (int i = 0; i <= 19; i++) {
            next[i] = i + 1;
        }
        next[20] = 32;

        next[21] = 22;
        next[22] = 23;
        next[23] = 29;

        next[24] = 25;
        next[25] = 29;

        next[26] = 27;
        next[27] = 28;
        next[28] = 29;

        next[29] = 30;
        next[30] = 31;
        next[31] = 20;
    }

    public static void setScore(int[] score) {
        for (int i = 0; i <= 20; i++) {
            score[i] = 2 * i;
        }

        score[21] = 13;
        score[22] = 16;
        score[23] = 19;

        score[24] = 22;
        score[25] = 24;

        score[26] = 28;
        score[27] = 27;
        score[28] = 26;

        score[29] = 25;
        score[30] = 30;
        score[31] = 35;
    }

    public static void setBlue(int[] blue) {
        blue[5] = 21;
        blue[10] = 24;
        blue[15] = 26;
    }

    public static int move(int pos, int dice) {

        int cur = pos;
        for (int i = 0; i < dice; i++) {
            if (i == 0 && blue[cur] != 0) {
                cur = blue[cur];
            }
            else {
                cur = next[cur];
            }

            if (cur == END) {    //도착
                break;
            }
        }
        return cur;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dices = new int[10];
        for (int i = 0; i < 10; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }
}
