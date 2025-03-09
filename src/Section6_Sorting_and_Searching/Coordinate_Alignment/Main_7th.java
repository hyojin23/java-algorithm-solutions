package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point_7th implements Comparable<Point_7th> {

    int x, y;

    Point_7th(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point_7th ob) {
        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main_7th {

    public void solution(List<Point_7th> list) {

        Collections.sort(list);
        for (Point_7th p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point_7th> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point_7th(x, y));
        }

        T.solution(list);
    }
}
