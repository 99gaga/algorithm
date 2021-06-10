package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 두개이하로다른비트 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new long[]{3, 11}, solution(new long[]{2, 7}));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            String binary = Long.toBinaryString(num);

            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                binary = "0" + binary;
                int lastZeroIdx = binary.lastIndexOf("0");
                String nextNum = binary.substring(0, lastZeroIdx) + "10" +binary.substring(lastZeroIdx+2);
                answer[i] = Long.parseLong(nextNum, 2);
            }
        }

        return answer;
    }
}
