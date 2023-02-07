package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
public class 호텔대실 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(new String[][]{
                {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}
        }));
        Assertions.assertEquals(1, solution(new String[][]{
                {"09:10", "10:10"}, {"10:20", "12:20"}
        }));
        Assertions.assertEquals(3, solution(new String[][]{
                {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}
        }));
    }

    public int solution(String[][] book_time) {
        List<int[]> reserveTimes = new ArrayList<>(book_time.length);

        for (int i = 0; i < book_time.length; i++) {
            String[] time  = book_time[i];
            int inTime = parseMinuteTime(time[0]);
            int outTime = parseMinuteTime(time[1]);
            reserveTimes.add(new int[]{inTime, outTime});
        }

        Collections.sort(reserveTimes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        List<Integer> rooms = new ArrayList<>();
        for (int[] reserveTime : reserveTimes) {
            int startTime = reserveTime[0];
            int endTime = reserveTime[1] + 10;

            boolean isNeedNewRoom = true;
            for (int i = 0; i < rooms.size(); i++) {
                int lastReserveTime = rooms.get(i);
                if (lastReserveTime <= startTime) {
                    rooms.set(i, endTime);
                    isNeedNewRoom = false;
                    break;
                }
            }

            if (isNeedNewRoom) {
                rooms.add(endTime);
            }
        }

        return rooms.size();
    }

    private int parseMinuteTime(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }

}
