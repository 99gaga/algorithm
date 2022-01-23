package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 주차요금계산 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{14600, 34400, 5000}, solution(
                new int[]{180, 5000, 10, 600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"}));
        Assertions.assertArrayEquals(new int[]{0, 591}, solution(
                new int[]{120, 0, 60, 591},
                new String[]{
                        "16:00 3961 IN",
                        "16:00 0202 IN",
                        "18:00 3961 OUT",
                        "18:00 0202 OUT",
                        "23:58 3961 IN"}));
        Assertions.assertArrayEquals(new int[]{14841}, solution(
                new int[]{1, 461, 1, 10},
                new String[]{
                        "00:00 1234 IN"}));
    }

    final static int LAST_TIME = 60 * 24 - 1;
    static int DEFAULT_TIME, DEFAULT_FEE, UNIT_TIME, UNIT_FEE;

    public int[] solution(int[] fees, String[] records) {
        DEFAULT_TIME = fees[0];
        DEFAULT_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];

        Map<String, Integer> results = new TreeMap<>(); // 최종 주차장 이용 시간 map (carNumber, totalTime)
        Map<String, Integer> maps = new HashMap<>(); // 임시저장용 입출차 기록용 map (carNumber, inTime)

        for (String record : records) {
            String[] inputs = record.split(" ");
            int time = makeMinute(inputs[0]);
            String carNumber = inputs[1];
            boolean isIn = !maps.containsKey(carNumber);
            if (isIn) {
                maps.put(carNumber, time);
            } else {
                int inTime = maps.get(carNumber);
                results.put(carNumber, results.getOrDefault(carNumber, 0) + (time - inTime));
                maps.remove(carNumber);
            }
        }

        for (String carNumber : maps.keySet()) {
            int inTime = maps.get(carNumber);
            results.put(carNumber, results.getOrDefault(carNumber, 0) + (LAST_TIME - inTime));
        }

        return results.values().stream()
                .map(this::calcFee)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int calcFee(int time) {
        int addFee = (time > DEFAULT_TIME)
                ? (int) Math.ceil((time - DEFAULT_TIME) / (double) UNIT_TIME) * UNIT_FEE // 추가요금 계산 식
                : 0;
        return DEFAULT_FEE + addFee;
    }

    private int makeMinute(String time) { // hh:mm
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

}
