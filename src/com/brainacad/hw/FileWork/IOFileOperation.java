package com.brainacad.hw.FileWork;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IOFileOperation {

    private final String MYSTRING = "Java forever";

    public IOFileOperation() {
    }

    public boolean writToFile(String path, String data)throws IOException{
        FileWriter writer = new FileWriter(path, false);
            writer.write(data);
            writer.flush();
            writer.close();
            return true;
    }

    public String readFromFile (String path)throws IOException{
        List<String> fis = Files.readAllLines(Paths.get(path));
        addPathToList(path, fis);
       return  listToString(fis);
    }

    private void addPathToList(String path, List<String> fis){
        fis.add(path);
        fis.add(MYSTRING);
    }

    private String listToString(List<String> fis){
        StringBuilder builder = new StringBuilder();
        for (String str: fis) {
            builder.append(str + "\n");
        }
        return builder.toString();
    }

}
