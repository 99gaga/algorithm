package programmers;

/**
 * 조이스틱
 */
public class Joystick {

    public static void main(String[] args) {
        String name = "JEROEN";

        int result = solution(name);
        System.out.println(result);
    }

    private static int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            // 위 아래
            if (name.charAt(i) <= 'M') {
                answer += name.charAt(i) - 'A';
            } else {
                answer += 'Z' - name.charAt(i) + 1;
            }

            // 좌 우
            int idx = i + 1;
            while (idx < length && name.charAt(idx) == 'A') {
                idx++;
            }

            minMove = Math.min(minMove, length - idx + i + Math.min(i, length - idx));
        }

        answer += minMove;

        return answer;
    }
}