package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996
public class 시소짝꿍 {

    @Test
    public void test() {
        Assertions.assertEquals(
                4,
                solution(new int[]{100, 180, 360, 100, 270})
        );
    }

    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> info = new HashMap<>();

        // 1:1, 1:2, 2:1, 2:3, 3:2, 3:4, 4:3 weight
        for (int w : weights) {
            answer += info.getOrDefault(w * 1.0, 0)
                    + info.getOrDefault(w * 2.0, 0)
                    + info.getOrDefault(w / 2.0, 0)
                    + info.getOrDefault(w * 2.0 / 3.0, 0)
                    + info.getOrDefault(w * 3.0 / 2.0, 0)
                    + info.getOrDefault(w * 3.0 / 4.0, 0)
                    + info.getOrDefault(w * 4.0 / 3.0, 0);

            info.put(w * 1.0, info.getOrDefault(w * 1.0, 0) + 1);
        }

        return answer;
    }
}
