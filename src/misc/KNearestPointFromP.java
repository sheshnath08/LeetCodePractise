package misc;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by sheshnath on 5/19/2017.
 */
public class KNearestPointFromP {

    class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }

    private List<Point> kNearestPoint(List<Point> points, Point p, int k){
        List<Point> res = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(k + 1, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return distance(p,o2)- distance(p, o1);
            }
        });

        for( Point point:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        Iterator<Point> it = pq.iterator();
        while (it.hasNext()){
            res.add(it.next());
        }

        return res;
    }

    private int distance(Point a, Point b){
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }
}
