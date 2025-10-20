package backjoon_exam;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> que = new ArrayDeque<>();

        // 1 ~ n을 큐에 넣기
        for (int i = 1; i <= n; i++) {
            que.offer(i); // 큐의 뒤에 추가
        }

        // 카드가 1장 남을 때까지 반복
        while (que.size() > 1) {
            // int temp = que.peek();
            que.poll(); // 맨앞 원소 제거
            que.offer(que.poll());
        }

        bw.write(String.valueOf(que.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}
