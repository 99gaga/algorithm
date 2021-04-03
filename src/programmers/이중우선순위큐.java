package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 16", "D 1"}));
        Assertions.assertArrayEquals(new int[]{7, 5}, solution(new String[]{"I 7", "I 5", "I -5", "D -1"}));
        Assertions.assertArrayEquals(new int[]{5, 5}, solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"}));
    }

    public Queue<Integer> ascQueue = new PriorityQueue<>();
    public Queue<Integer> descQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int[] solution(String[] operations) {
        int[] answer = {};

        for (int i=0; i<operations.length; i++) {
            String[] operation = operations[i].split(" ");
            interpret(operation[0], Integer.parseInt(operation[1]));
        }

        int max = descQueue.peek() == null ? 0 : descQueue.poll();
        int min = ascQueue.peek() == null ? 0 : ascQueue.poll();

        answer = new int[]{max, min};
        return answer;
    }

    public void interpret(String c, int number) {
        if (c.equals("I")) {
            ascQueue.offer(number);
            descQueue.offer(number);
        } else if (c.equals("D") && !ascQueue.isEmpty()) {

            if (number == 1) {
                int value = descQueue.poll();
                ascQueue.remove(value);
            } else {
                int value = ascQueue.poll();
                descQueue.remove(value);
            }
        }
    }
}
