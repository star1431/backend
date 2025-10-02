package backjoon_exam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    // 소수 여부
    public static boolean isPrime(int n) {
        // 0, 1 소수아님
        if(n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0)  return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // N = 수의 개수


        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> nums = new ArrayList<>();
        while(st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(isPrime(nums.get(i))) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}
