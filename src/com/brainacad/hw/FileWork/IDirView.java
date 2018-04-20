package com.brainacad.hw.FileWork;

import java.io.IOException;
import java.util.Map;

public interface IDirView {
    void getListOfFile();
    void getListOfMaskFile(String mask);
    void print();
    void changerFiles() throws IOException;
    boolean toHashMap(String key, String value);
    Map<String, String> getFileMap();
}