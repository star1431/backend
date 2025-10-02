package week_07._0922;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // N = 참가자수

        st = new StringTokenizer(br.readLine(), " "); // 사이즈별 신청자 수
        List<Integer> sizeLists = new ArrayList<Integer>();
        while(st.hasMoreTokens()) {
            sizeLists.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int t =  Integer.parseInt(st.nextToken()); // T = 티셔츠 묶음 수
        int p =  Integer.parseInt(st.nextToken()); // P = 펜 묶음 수

        int[] arr = new int[sizeLists.size()];
        for (int i = 0; i < sizeLists.size(); i++) {
            if(sizeLists.get(i) == 0) arr[i] = 0;
            else if(sizeLists.get(i) <= t) arr[i] = 1;
            else arr[i] = (int) Math.ceil(sizeLists.get(i) / (double) t);
        }

        int sum = 0;
        for (int item : arr) {
            sum += item;
        }

        int bundleP = (int) (n / p);
        int leftP = (int) (n % p);

        System.out.println(sum); // T 최소 묶음 합계
        System.out.printf("%d %d\n", bundleP, leftP); // P 최대묶음, 나머지

        br.close();
    }
}
