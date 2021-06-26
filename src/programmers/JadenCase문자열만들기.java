package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JadenCase문자열만들기 {

    @Test
    void test() {
        Assertions.assertEquals("3people Unfollowed Me", solution("3people unFollowed me"));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String[] words = s.split(" ");
        for (String word : words) {
            if (Character.isAlphabetic(word.charAt(0))) {
                answer.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.toLowerCase().substring(1));
            } else {
                answer.append(word.toLowerCase());
            }
            answer.append(" ");
        }

        return answer.substring(0, answer.lastIndexOf(" "));
    }

}
