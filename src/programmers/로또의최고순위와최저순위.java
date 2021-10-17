package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 로또의최고순위와최저순위 {

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
                ),
                new int[]{3, 5});
        Assertions.assertArrayEquals(solution(
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{38, 19, 20, 40, 15, 25}
                ),
                new int[]{1, 6});
        ;
        Assertions.assertArrayEquals(solution(
                new int[]{45, 4, 35, 20, 3, 9},
                new int[]{20, 9, 3, 45, 4, 35}
                ),
                new int[]{1, 1});
        ;
        solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Set<Integer> winNumberSet = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toSet());

        int count = 0;
        int zero = 0;
        for (int i=0; i<6; i++) {
            if (winNumberSet.contains(lottos[i])) count++;
            if (lottos[i] == 0) zero++;
        }

        answer[0] = getRank(count + zero);
        answer[1] = getRank(count);

        return answer;
    }

    public int getRank(int count) {
        if (count > 1) {
            return 7 - count;
        }
        return 6;
    }
}
