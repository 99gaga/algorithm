package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class 파일명정렬 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"}, solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
        Assertions.assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}, solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] first = split(o1);
            String[] second = split(o2);

            int result = first[0].compareTo(second[0]);
            if (result != 0) {
                return result;
            } else {
                return Integer.parseInt(first[1]) - Integer.parseInt(second[1]);
            }
        });

        return files;
    }

    private static String[] split(String s) {
        String[] results = new String[2];
        int len = s.length();
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        while (idx < len) {
            if (Character.isDigit(s.charAt(idx))) break;
            sb.append(s.charAt(idx++));
        }

        results[0] = sb.toString().toLowerCase();
        sb = new StringBuilder();

        while (idx < len) {
            if (!Character.isDigit(s.charAt(idx))) break;
            sb.append(s.charAt(idx++));
        }

        results[1] = sb.toString();
        return results;
    }

}
