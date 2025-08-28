package week_03._0827;

public class StrBuildAndBuffer {
    public static void main(String[] args) {
        int loop = 100_000;
        long start, end;

        // String (불변 → 매번 새 객체 생성 → 가장 느림)
        start = System.currentTimeMillis();    // 시작시간
        String str = "";
        // loop 만큼 돌려서 시간지연 발생시키기
//        for (int i = 0; i < loop; i++) {
//            str += "a";
//        }
        end = System.currentTimeMillis();     // 종료시간
//        System.out.println("String 걸린 시간: " + (end - start) + "ms");

        // StringBuilder (가변, 동기화 ❌ → 빠름)
        start = System.currentTimeMillis();   // 시작시간
        StringBuilder sb = new StringBuilder();
        // loop 만큼 돌려서 시간지연 발생시키기
        for (int i = 0; i < loop; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();    // 종료시간
        System.out.println("StringBuilder 걸린 시간: " + (end - start) + "ms");

        // StringBuffer (가변, 동기화 ⭕ → Builder보다 조금 느림)
        start = System.currentTimeMillis();  // 시작시간
        StringBuffer sbf = new StringBuffer();
        // loop 만큼 돌려서 시간지연 발생시키기
        for (int i = 0; i < loop; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();   // 종료시간
        System.out.println("StringBuffer 걸린 시간: " + (end - start) + "ms");

        StrBuildAndBuffer sbb = new StrBuildAndBuffer();
        sbb.exam();
    }

    public void exam() {
        // ---------- StringBuilder ----------
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("SB append   : " + sb);  // Hello World

        sb.insert(5, ",");
        System.out.println("SB insert   : " + sb);  // Hello, World

        sb.delete(5, 7); // [start, end) end는 미포함 → 인덱스 5~6 삭제
        System.out.println("SB delete   : " + sb);  // HelloWorld

        sb.reverse();
        System.out.println("SB reverse  : " + sb);  // dlroWolleH

        // 메서드 체이닝 예시
        StringBuilder sb2 = new StringBuilder("ab");
        sb2.append("cd").insert(2, "-").reverse();
        System.out.println("SB chaining : " + sb2); // dc-ba

        // ---------- StringBuffer ----------
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("SBF append  : " + sbf); // Hello World

        sbf.insert(5, ",");
        System.out.println("SBF insert  : " + sbf); // Hello, World

        sbf.delete(5, 7);
        System.out.println("SBF delete  : " + sbf); // HelloWorld

        sbf.reverse();
        System.out.println("SBF reverse : " + sbf); // dlroWolleH
    }
}
