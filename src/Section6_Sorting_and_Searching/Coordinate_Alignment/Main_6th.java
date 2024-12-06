package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point_6th implements Comparable<Point_6th> {

    int x, y;

    Point_6th(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point_6th ob) {
        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main_6th {

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point_6th(x, y));
        }

        Collections.sort(list);
        for (Point_6th p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
