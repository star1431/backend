package week_03._0828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class collectionExam2 {
    private static class Pen {
        String type;
        String color;

        public Pen(String type, String color) {
            this.type = type;
            this.color = color;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Pen{" +
                    "type='" + type + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pen pen = (Pen) o;
            return Objects.equals(type, pen.type) && Objects.equals(color, pen.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, color);
        }
    }

    public static void main(String[] args) {
        List<Pen> pen = new ArrayList<>();
        pen.add(new Pen("볼펜", "검정"));
        pen.add(new Pen("연필", "파랑"));
        pen.add(new Pen("샤프", "빨강"));

        pen.add(new Pen("연필", "검정"));
        pen.add(new Pen("연필", "초록"));

        // Map<문자열, List<Pen>>
        Map<String, List<Pen>> map = new HashMap<>();

        // key 타입 기준 삽입
        for (Pen p : pen) {
            String type = p.getType();
            // 해당키 없으면 생성
            if (!map.containsKey(type)) {
                map.put(type, new ArrayList<>());
            }
            // 해당키에 벨류 삽입
            map.get(type).add(p);
        }

        for (Map.Entry<String, List<Pen>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        /*
         * 볼펜 : [Pen{type='볼펜', color='검정'}]
         * 샤프 : [Pen{type='샤프', color='빨강'}]
         * 연필 : [Pen{type='연필', color='파랑'}, Pen{type='연필', color='검정'}, Pen{type='연필', color='초록'}]
         */
    }
}
