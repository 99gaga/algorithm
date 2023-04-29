package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 두큐합같게만들기 {

    @Test
    public void test() {
        Assertions.assertEquals(
                2,
                solution(
                        new int[]{3, 2, 7, 2},
                        new int[]{4, 6, 5, 1}
                )
        );
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) {
            sum1 += num;
            q1.add(num);
        }
        for (int num : queue2) {
            sum2 += num;
            q2.add(num);
        }

        // 홀 수인 경우 두 합을 같게 만들 수 없음
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int max = (queue1.length + queue2.length) * 2;
        int count = 0;
        while (sum1 != sum2) {
            if (count > max) {
                return -1;
            }

            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.add(value);
            } else if (sum1 < sum2) {
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.add(value);
            }

            count++;
        }

        return count;
    }

}
