package com.yaco.FileWriter.FileWriter.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaco.FileWriter.FileWriter.lib.FileWriter;
import org.springframework.web.bind.annotation.*;

@RestController
public class WriteFileByCall {

    private final FileWriter fileWriter = new FileWriter();

    private record NewFileData(String content, String fileName){};

    @PostMapping("/write-file")
    public String writeFile(@RequestBody String json) throws Exception {
        // map the json to object
        ObjectMapper mapper = new ObjectMapper();
        NewFileData data = mapper.readValue(json, NewFileData.class);

        this.fileWriter.write(data.fileName, data.content);
        return "Content Written to file " + data.fileName;
    }


}
