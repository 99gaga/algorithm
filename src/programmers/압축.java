package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 압축 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{11, 1, 27, 15}, solution("KAKAO"));
        Assertions.assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, solution("TOBEORNOTTOBEORTOBEORNOT"));
        Assertions.assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, solution("ABABABABABABABAB"));
    }

    public int[] solution(String msg) {
        List<Integer> results = new ArrayList<>();

        // init
        Map<String, Integer> dict = new HashMap<>();
        char c = 'A';
        for (int i=1; i<=26; i++) dict.put(c++ + "", i);

        while (msg.length() > 0) {
            int length = msg.length();
            String str = msg.substring(0, 1);

            int idx = 1;
            while (idx < length) {
                if (dict.containsKey(str + msg.charAt(idx))) {
                    str += msg.charAt(idx);
                } else {
                    results.add(dict.get(str)); // 제일 긴 문자열의 값 추가
                    dict.put(str + msg.charAt(idx), dict.size() + 1); // 사전등록
                    break;
                }
                idx++;
            }

            if (idx == msg.length()) {
                results.add(dict.get(str));
            }
            msg = msg.substring(str.length());
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

}
