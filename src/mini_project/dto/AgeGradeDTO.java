package mini_project.dto;

/**
 * 관람등급 DTO
 * @author 정병천
 * @since 2025-09-17
 */
public class AgeGradeDTO {
    private String code;   // 'ALL', 'R12', 'R15', 'R19' (PK)
    private String label;  // '전체 이용가' 등

    public AgeGradeDTO() {}

    public AgeGradeDTO(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "AgeGradeDTO{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}