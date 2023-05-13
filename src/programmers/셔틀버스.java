package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.PriorityQueue;
import java.util.Queue;

public class 셔틀버스 {

    @Test
    public void test() {
        Assertions.assertEquals(
                "09:00",
                solution(
                        1, 1, 5,
                        new String[]{"08:00", "08:01", "08:02", "08:03"}
                )
        );
        Assertions.assertEquals(
                "09:09",
                solution(
                        2, 10, 2,
                        new String[]{"09:10", "09:09", "08:00"}
                )
        );
        Assertions.assertEquals(
                "08:59",
                solution(
                        2, 1, 2,
                        new String[]{"09:00", "09:00", "09:00", "09:00"}
                )
        );
        Assertions.assertEquals(
                "00:00",
                solution(
                        2, 1, 2,
                        new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}
                )
        );
        Assertions.assertEquals(
                "09:00",
                solution(
                        1, 1, 1,
                        new String[]{"23:59"}
                )
        );
        Assertions.assertEquals(
                "18:00",
                solution(
                        10, 60, 45,
                        new String[]{
                                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"
                        }
                )
        );
    }

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            String[] timeSplit = time.split(":");
            int timeOfMinute = (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);
            pq.add(timeOfMinute);
        }

        int busStartTime = 9 * 60, lastTime = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!pq.isEmpty() && pq.peek() <= busStartTime && cnt < m) {
                int currentTime = pq.poll();
                cnt++;
                lastTime = currentTime - 1;
            }
            if (i == n - 1 && cnt < m) {
                lastTime = busStartTime;
            }
            busStartTime += t;
        }

        return String.format("%02d:%02d", lastTime / 60, lastTime % 60);
    }
}
