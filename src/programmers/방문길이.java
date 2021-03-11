package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 방문길이 {

    @Test
    public void test() {
        Assertions.assertEquals(1, solution("UDU"));
        Assertions.assertEquals(7, solution("ULURRDLLU"));
        Assertions.assertEquals(7, solution("LULLLLLLU"));
    }

    static Map<Character, int[]> command = new HashMap<>() {{
        put('U', new int[]{0, 1});
        put('D', new int[]{0, -1});
        put('R', new int[]{1, 0});
        put('L', new int[]{-1, 0});
    }};

    private int solution(String dirs) {
        int answer = 0;
        int len = dirs.length();
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();

        int[] position = {0, 0};
        for (int i = 0; i < len; i++) {
            int[] dir = command.get(dirs.charAt(i));
            int tx = position[0] + dir[0];
            int ty = position[1] + dir[1];

            if (!(tx >= -5 && tx <= 5 && ty >= -5 && ty <= 5)) continue;

            int[] des = {tx, ty};
            if (isValid(from, to, des, position)) {
                answer++;
            }

            from.add(position);
            to.add(des);
            position = des;
        }

        return answer;
    }

    private boolean isValid(List<int[]> from, List<int[]> to, int[] des, int[] pos) {
        int size = from.size();
        for (int i = 0; i < size; i++) {
            if ((Arrays.equals(pos, from.get(i)) && Arrays.equals(des, to.get(i)))
                    || (Arrays.equals(des, from.get(i)) && Arrays.equals(pos, to.get(i)))) {
                return false;
            }
        }

        return true;
    }
}
