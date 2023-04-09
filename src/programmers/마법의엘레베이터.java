package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 마법의엘레베이터 {

    @Test
    public void test() {
        Assertions.assertEquals(6, solution(16));
        Assertions.assertEquals(16, solution(2554));
    }

    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int unitDigit = storey % 10;
            int tenDigit = (storey / 10) % 10;

            // 5 이상
            if (unitDigit > 5 || (unitDigit == 5 && tenDigit >= 5)) {
                answer += 10 - unitDigit;
                storey += 10;
            } else {
                answer += unitDigit;
            }

            storey /= 10;
        }

        return answer;
    }
}
