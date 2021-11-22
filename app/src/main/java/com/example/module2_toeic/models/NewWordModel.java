package com.example.module2_toeic.models;

public class NewWordModel {
    int id;
    String word;
    String vietnamese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public NewWordModel(int id, String word, String vietnamese) {
        this.id = id;
        this.word = word;
        this.vietnamese = vietnamese;
    }
}
