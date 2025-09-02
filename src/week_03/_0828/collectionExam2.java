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
    }
}
