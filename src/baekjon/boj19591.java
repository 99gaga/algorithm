package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 독특한 계산기
 */
public class boj19591 {

    static List<Long> number = new LinkedList<>();
    static List<Character> sign = new LinkedList<>();
    static Map<Character, Integer> orders = new HashMap<>(){{
        put('*', 0);
        put('/', 0);
        put('-', 2);
        put('+', 2);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int length = input.length();

        for (int i=0; i<length; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (i != 0) {
                    number.add(Long.parseLong(sb.toString()));
                    sb = new StringBuilder();
                }
                sign.add(c);
            }
        }
        number.add(Long.parseLong(sb.toString()));

        if (input.charAt(0) == '-') { // 첫 숫자가 음수라면
            sign.remove(0);
            number.add(0, -number.remove(0));
        }

        int signSize = sign.size();
        int numberSize = number.size();

        while (numberSize > 2) {

            // 앞쪽
            Long frontA = number.get(0);
            Long frontB = number.get(1);
            char frontOp = sign.get(0);
            long frontResult = calc(frontA, frontB, frontOp);

            // 뒤쪽
            Long backA = number.get(numberSize - 2);
            Long backB = number.get(numberSize - 1);
            char backOp = sign.get(signSize - 1);
            long backResult = calc(backA, backB, backOp);

            if (orders.get(frontOp) != orders.get(backOp)) {

                if (orders.get(frontOp) < orders.get(backOp)) {
                    frontCalc(frontResult);
                } else {
                    backCalc(backResult, numberSize - 1, signSize - 1);
                }
            } else {

                if (frontResult >= backResult) {
                    frontCalc(frontResult);
                } else {
                    backCalc(backResult, numberSize - 1, signSize - 1);
                }
            }

            numberSize--;
            signSize--;
        }

        long result;
        if (sign.size() == 1) {
             result = calc(number.remove(0), number.remove(0), sign.remove(0));
        } else {
            result = number.remove(0);
        }

        System.out.println(result);
    }

    private static void backCalc(long backResult, int numberIdx, int signIdx) {
        number.remove(numberIdx);
        number.remove(numberIdx - 1);
        sign.remove(signIdx);
        number.add(backResult);
    }

    private static void frontCalc(long frontResult) {
        number.remove(0);
        number.remove(0);
        sign.remove(0);
        number.add(0, frontResult);
    }

    public static long calc(long a, long b, char op) {

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return a / b;
        }
    }

}
