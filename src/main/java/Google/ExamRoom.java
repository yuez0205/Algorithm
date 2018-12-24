package Google;

import java.util.*;

public class ExamRoom {
    int N;
    PriorityQueue<Interval> heap;

    public ExamRoom(int N) {  // 0..N-1
        this.N = N;
        heap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.dist == o2.dist) {
                    return o1.start - o2.start;
                }
                return o2.dist - o1.dist;
            }
        });
        heap.offer(new Interval(-1, N));
    }

    public int seat() {
        Interval interval = heap.poll();
        int seat = 0;
        if (interval.start == -1) {
            seat = 0;
        } else if (interval.end == N) {
            seat = N-1;
        } else {
            seat = (interval.end + interval.start) / 2;
        }
        heap.offer(new Interval(interval.start, seat));
        heap.offer(new Interval(seat, interval.end));
        return seat;
    }

    public void leave(int p) {
        Interval head = null, tail = null;
        Iterator it = heap.iterator();
        while (it.hasNext()) {
            Interval in = (Interval) it.next();
            if (in.end == p) {
                head = in;
            }
            if (in.start == p) {
                tail = in;
            }
            if (head != null && tail != null) {
                break;
            }
        }
        heap.remove(head);
        heap.remove(tail);
        heap.offer(new Interval(head.start, tail.end));
    }

    public class Interval {
        int start, end, dist;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            if (start == -1) {
                dist = end;
            } else if (end == N) {
                dist = N - 1 - start;
            } else {
                dist = Math.abs(end - start) / 2;
            }
        }
    }



    public static void main(String[] args) {
        String[] inputs = new String[]{"ExamRoom","seat","seat","seat","seat","leave","seat"};
        int[][] values = {{10},{},{},{},{},{4},{}};
        Integer[] Output = {null,0,9,4,2,null,5};
    }
}
