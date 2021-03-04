package programmers;


/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천
 */
public class NewId {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        String result = solution(new_id);

        System.out.println(result);
    }

    private static String solution(String new_id) {

        return new KakaoId(new_id)
                .toLowerCase()
                .filter()
                .toSingleDot()
                .filterStartEndDot()
                .isBlank()
                .isLengthThan16()
                .isLessThan2()
                .getResult();
    }

    static class KakaoId {
        private String id;

        public KakaoId(String id) {
            this.id = id;
        }

        private KakaoId toLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        private KakaoId filter() {
            id = id.replaceAll("[^a-z0-9\\-_.]", "");
            return this;
        }

        private KakaoId toSingleDot() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KakaoId filterStartEndDot() {
            id = id.replaceAll("^[.]|[,]$", "");
            return this;
        }

        private KakaoId isBlank() {
            id = id.isEmpty() ? "a" : id;
            return this;
        }

        private KakaoId isLengthThan16() {
            if (id.length() >= 16) {
                id = id.substring(0, 15);
            }
            id = id.replaceAll("[.]$", "");
            return this;
        }

        private KakaoId isLessThan2() {
            StringBuilder sb = new StringBuilder(id);
            while (sb.length() <= 2) {
                sb.append(id.charAt(id.length()-1));
            }
            id = sb.toString();

            return this;
        }

        private String getResult() {
            return id;
        }
    }

}