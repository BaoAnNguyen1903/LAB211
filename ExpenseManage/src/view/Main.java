import controller.Programming;

public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Add an expense","Display all expenses","Delete an expense", "Quit"};
        Programming program = new Programming("=======Handy Expense program======", mChon);
        program.run();
    }
}