package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Point_5th implements Comparable<Point_5th> {

    int x;
    int y;

    Point_5th(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point_5th ob) {
        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main_5th {

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        List<Point_5th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y  = sc.nextInt();
            list.add(new Point_5th(x, y));
        }

        Collections.sort(list);

        for (Point_5th c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }
}