package Main;

import controller.FileProcessorController;
import java.util.Scanner;
import model.FileProcessorModel;
import view.FileProcessorView;

public class FileProcessorMain {
    public static void main(String[] args) {
        FileProcessorModel model = new FileProcessorModel();
        FileProcessorView view = new FileProcessorView();
        FileProcessorController controller = new FileProcessorController(model, view);

        while (true) {
            view.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            controller.processOption(option);
        }
    }
}