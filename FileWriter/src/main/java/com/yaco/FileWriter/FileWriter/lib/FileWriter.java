package com.yaco.FileWriter.FileWriter.lib;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileWriter {


    public void write(String path, String content) {
        List<String> lines = List.of(content);
        Path filePath = Paths.get(path);
        try {
            Files.write(filePath, lines);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
