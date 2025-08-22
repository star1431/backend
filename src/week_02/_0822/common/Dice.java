package week_02._0822.common;

public class Dice {
    //어떤 속성이 필요할까요??
    //속성 - 면, 눈
    protected int face = 6;
    private int eye;

    public void roll() {
        eye = (int)(Math.random() * face) + 1;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }
    
    public int getEye() {
        return eye;
    }
}