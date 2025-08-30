package week_03._0829.mini_project.enums;

/**
 * AgeRating enum
 * info : 영화 관람 등급
 * @author 정병천
 */
public enum AgeRating {
    ALL(1, "전체 이용가"),
    R12(2, "12세 이용가"),
    R15(3, "15세 이용가"),
    R19(4, "청소년 관람불가");
    private int code;
    private String label;

    AgeRating(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    // code -> label
    public static String findLabel(String code) {
        int target = Integer.parseInt(code);
        for (AgeRating item : AgeRating.values()) {
            if (item.code == target) {
                return item.label;
            }
        }
        return null;
    }
    
    // 코드값 배열 get
    public static int[] getCodeArray() {
        AgeRating[] values = AgeRating.values();
        int[] codeArr = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            codeArr[i] = values[i].getCode();
        }
        return codeArr;
    }

    // 라벨명 배열 get
    public static String[] getLabelArray() {
        AgeRating[] values = AgeRating.values();
        String[] labelArr = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            labelArr[i] = values[i].getLabel();
        }
        return labelArr;
    }
}
