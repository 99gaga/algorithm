package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 보석쇼핑 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{3, 7}, solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE"}));
        Assertions.assertArrayEquals(new int[]{1, 3}, solution(new String[]{"AA", "AB", "AC", "AA", "AC"}));
        Assertions.assertArrayEquals(new int[]{1, 1}, solution(new String[]{"XYZ", "XYZ", "XYZ"}));
        Assertions.assertArrayEquals(new int[]{1, 5}, solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
        Assertions.assertArrayEquals(new int[]{6, 8}, solution(new String[]{"A", "B", "A", "A", "A", "C", "A", "B"}));
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = Arrays.stream(gems).collect(Collectors.toSet());
        Map<String, Integer> cntMap = new HashMap<>();
        int size = gemSet.size();

        int minRange = gems.length;
        int start = 0;
        int minStart = 0;
        for (int end=0; end<gems.length; end++) {
            cntMap.put(gems[end], cntMap.getOrDefault(gems[end], 0) + 1);

            while (cntMap.size() == size) {
                if (minRange > end - start) {
                    minRange = end - start;
                    minStart = start;
                }

                if (cntMap.get(gems[start]) == 1) {
                    cntMap.remove(gems[start]);
                } else {
                    cntMap.put(gems[start], cntMap.get(gems[start]) - 1);
                }
                start++;
            }
        }

        answer[0] = minStart + 1;
        answer[1] = minStart + minRange + 1;

        return answer;
    }

}
