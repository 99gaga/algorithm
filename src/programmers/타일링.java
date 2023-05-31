package programmers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 타일링 {

    @Test
    public void test() {
        Assertions.assertEquals(5, solution(4));
    }

    public int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }

        return arr[n - 1];
    }

}
