package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
public class 디펜스게임 {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        Assertions.assertEquals(4, solution(2, 4, new int[]{3, 3, 3, 3}));
    }

    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int round = 0; round < enemy.length; round++) {
            queue.add(enemy[round]);
            if (queue.size() > k) {
                n -= queue.poll();
            }
            if (n < 0) {
                return round;
            }
        }

        return enemy.length;
    }

}
