package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class 귤고르기 {

    @Test
    void test() {
        Assertions.assertEquals(3, solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(2, solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(1, solution(2, new int[]{1, 1, 1, 2, 2, 2, 3}));
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> duplications = Arrays
                .stream(tangerine)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), e -> 1, (a, b) -> a + 1, HashMap::new))
                .values()
                .stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (int duplication : duplications) {
            answer++;
            k -= duplication;
            if (k <= 0) break;
        }

        return answer;
    }

}
