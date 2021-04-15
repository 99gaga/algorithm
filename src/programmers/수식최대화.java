package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {

    @Test
    void test() {
        Assertions.assertEquals(60420, solution("100-200*300-500+20"));
        Assertions.assertEquals(300, solution("50*6-3*2"));
    }

    List<Long> number;
    List<Character> operation;
    char[] op = new char[]{'-', '*', '+'};
    long max;

    public long solution(String expression) {
        number = new ArrayList<>();
        operation = new ArrayList<>();
        max = 0;

        StringBuilder sb = new StringBuilder();
        int length = expression.length();
        for (int i=0; i<length; i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                number.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operation.add(c);
            }
        }
        number.add(Long.parseLong(sb.toString()));

        // 연산 우선순위 순열 구하기
        permutation(0);

        return max;
    }

    public void permutation(int cnt) {
        if (cnt == 3) {
            getResult();
        }

        for (int i=cnt; i<3; i++) {
            swap(cnt, i);
            permutation(cnt + 1);
            swap(cnt, i);
        }

    }

    public void swap(int cnt, int i) {
        char temp = op[cnt];
        op[cnt] = op[i];
        op[i] = temp;
    }

    public void getResult() {
        List<Long> copyNumber = new ArrayList<>(number);
        List<Character> coypOperation = new ArrayList<>(operation);

        for (int i=0; i<3; i++) {
            char op = this.op[i];

            for (int j=0; j<coypOperation.size(); j++) {
                if (op == coypOperation.get(j)) {
                    long a = copyNumber.remove(j);
                    long b = copyNumber.remove(j);
                    char removeOp = coypOperation.remove(j);
                    long result = calc(a, b, removeOp);
                    copyNumber.add(j, result);
                    j--;
                }
            }
        }

        max = Math.max(max, Math.abs(copyNumber.get(0)));
    }

    public long calc(long a, long b, char op) {

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return (long) a * b;

        }
    }
}
