package week_04._0903;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
    public CustomException(Exception e) {
        super(e);
    }
}
