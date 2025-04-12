import controller.Programming;

public class main {
    public static void main(String[] args) {
        String mChon[] = {"Normal Calculator","BMI Calculator","Exit"};
        Programming program = new Programming("========= Calculator Program =========", mChon);
        program.run();
    }
}