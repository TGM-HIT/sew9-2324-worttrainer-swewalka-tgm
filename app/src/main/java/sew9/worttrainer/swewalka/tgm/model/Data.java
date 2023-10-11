package sew9.worttrainer.swewalka.tgm.model;

import java.util.ArrayList;

public class Data {
    private static class WordAndImage {
        String word;
        String imageLink;

        public WordAndImage(String word, String imageLink) {
            this.word = word;
            this.imageLink = imageLink;
        }

        public String getWord() {
            return word;
        }

        public String getImageLink() {
            return imageLink;
        }
    }

    private final ArrayList<WordAndImage> list;

    public Data() {
        this.list = new ArrayList<>();
    }

    public void add(String word, String bildLink) {
        this.list.add(new WordAndImage(word, bildLink));
    }

    public String getWord(int index) {
        if (index < 0 || index >= this.list.size()) {
            return null; // oder werfen Sie eine Ausnahme
        }
        return this.list.get(index).getWord();
    }

    public String getBildLink(int index) {
        if (index < 0 || index >= this.list.size()) {
            return null; // oder werfen Sie eine Ausnahme
        }
        return this.list.get(index).getImageLink();
    }
}
