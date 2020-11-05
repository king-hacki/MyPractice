package sum_of_intervals;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.max;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Interval {

    private int x;
    private int y;

    public Interval(int [] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null)
            return 0;
        var intervalList = createIntervalsFromArray(intervals);
        mergeOverlappingIntervals(intervalList);
        return intervalList.stream()
                .distinct()
                .mapToInt(Interval::size)
                .sum();
    }

    public static List<Interval> createIntervalsFromArray(int[][] intervals) {
        return stream(intervals)
                .map(Interval::new)
                .collect(toList());
    }

    public static void mergeOverlappingIntervals(List<Interval> intervalList) {
        for (Interval current : intervalList)
            for (int i = 0; i < intervalList.size(); i++) {
                Interval check = intervalList.get(i);
                if (current.isOverlap(check)) {
                    current.y = max(current.y, check.y);
                    intervalList.set(i, current);
                }
            }
    }

    public boolean isOverlap(Interval interval) {
        return x <= interval.x && y >= interval.x;
    }

    public int size() {
        return y - x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return x == interval.x &&
                y == interval.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }



  // best approach
//  public static int sumIntervals(int[][] intervals) {
//      return intervals == null ? 0 : (int) stream(intervals)
//              .flatMapToInt(interval -> range(interval[0], interval[1]))
//              .distinct()
//              .count();
//
//  }

}

