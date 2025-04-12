package Main;

import controller.DictionaryController;
import model.DictionaryModel;
import view.DictionaryView;

public class Main {
    public static void main(String[] args) {
        DictionaryModel model = new DictionaryModel();
        DictionaryController controller = new DictionaryController(model);
        DictionaryView view = new DictionaryView(controller);
        view.run();
    }
}
