package controller;

import model.DictionaryModel;

public class DictionaryController {
    public DictionaryModel model;

    public DictionaryController(DictionaryModel model) {
        this.model = model;
    }

    public boolean addWord(String eng, String vi) {
        return model.addWord(eng, vi);
    }

    public boolean removeWord(String eng) {
        return model.removeWord(eng);
    }

    public String translate(String eng) {
        return model.translate(eng);
    }
}
