package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class 할인행사 {

    @Test
    public void test() {
        Assertions.assertEquals(3, solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        ));
    }

    final int MEMBERSHIP_PERIOD  = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // init
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i = 0; i < MEMBERSHIP_PERIOD; i++) {
            String discountItem = discount[i];
            discountMap.put(discountItem, discountMap.getOrDefault(discountItem, 0) + 1);
        }

        if (isAllBuy(wantMap, discountMap)) {
            answer++;
        }

        for (int i = 1; i <= discount.length - MEMBERSHIP_PERIOD; i++) {
            String deleteItem = discount[i - 1];
            discountMap.put(deleteItem, discountMap.get(deleteItem) - 1);

            String addItem = discount[i - 1 + MEMBERSHIP_PERIOD];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);

            if (isAllBuy(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isAllBuy(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String item : wantMap.keySet()) {
            int wantCount = wantMap.get(item);
            if (wantCount > discountMap.getOrDefault(item, -1)) {
                return false;
            }
        }
        return true;
    }
}
