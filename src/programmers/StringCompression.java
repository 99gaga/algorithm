package programmers;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 문자열 압축
 */
public class StringCompression {

    public static void main(String[] args) {
        String s = "aabbaccc";

        int result = solution(s);
        System.out.println(result);
    }

    private static int solution(String s) {
        int answer = s.length();

        // 1개 단위부터 len/2 단위까지 비교
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int result = compression(s, unit, 1).length();
            answer = Math.min(answer, result);
        }

        return answer;
    }

    private static String compression(String s, int unit, int cnt) {
        if (s.length() < unit) return s;
        StringBuilder result = new StringBuilder();
        String pre = s.substring(0, unit);
        String post = s.substring(unit);

        // 불일치
        if (!post.startsWith(pre)) {
            if (cnt != 1) result.append(cnt);
            return result.append(pre).append(compression(post, unit, 1)).toString();
        }

        // 일치
        return result.append(compression(post, unit, cnt + 1)).toString();
    }

}

