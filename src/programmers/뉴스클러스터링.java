package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.*;

public class 뉴스클러스터링 {

    @Test
    void test() {
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        Assertions.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }

    final int NUMBER = 65536;

    public int solution(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> str1Map = new HashMap<>();
        int allCount = 0, crossCount = 0;

        for (int i=0; i<str1Length-1; i++) {
            if (isAlphabetic(str1.charAt(i)) && isAlphabetic(str1.charAt(i+1))) {
                String str = str1.substring(i, i+2);
                str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
                allCount++;
            }
        }

        for (int i=0; i<str2Length-1; i++) {
            if (!(isAlphabetic(str2.charAt(i)) && isAlphabetic(str2.charAt(i+1)))) continue;

            String str = str2.substring(i, i+2);
            if (str1Map.containsKey(str) && str1Map.get(str) > 0) { // 겹치는 경우
                str1Map.put(str, str1Map.get(str) - 1);
                crossCount++;
            } else { // 겹치지 않는 경우
                allCount++;
            }
        }

        if (crossCount == 0 && allCount == 0) {
            return NUMBER;
        }
        return (int) (crossCount * NUMBER / (double) allCount);
    }

}
