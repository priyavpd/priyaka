import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solver {
    public int maxPointsOnLine(List<Point> points) {
        int ans = 0;
        Map<Line, Integer> lines = new HashMap<Line, Integer>();
        for (Point a : points) {
            int max = 0;
            int same = 0;
            lines.clear();

            for (Point b : points) {
                if (a.x == b.x && a.y == b.y) {
                    ++same;
                } else {
                    Line line = new Line(b.x - a.x, b.y - a.y);
                    Integer count = lines.get(line);
                    if (count == null) {
                        count = 0;
                    }
                    ++count;
                    lines.put(line, count);
                    max = Math.max(max, count);
                }
            }
            ans = Math.max(ans, same + max);
        }
        return ans;
    }

    static class Line {
        final int dx;
        final int dy;

        Line(int dx, int dy) {
            if (dy == 0) {
                dx = Math.abs(dx);
            }
            else if (dy < 0) {
                dx = -dx;
                dy = -dy;
            }
            int gcd = gcd(Math.abs(dx), dy);
            dx /= gcd;
            dy /= gcd;
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Line)) {
                return false;
            }
            Line another = (Line)other;
            return dx == another.dy && dy == another.dy;
        }

        @Override
        public int hashCode() {
            return 31 * dx + dy;
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
