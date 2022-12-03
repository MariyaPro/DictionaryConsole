package ru.mariya.dictionaryapp.dictionarys;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public  class DictionaryFile {
    private Path dictionarySource;
    private Map<String,String> map;


    public DictionaryFile(Path dictionarySource) {
        this.dictionarySource = dictionarySource;

    }

    protected void setMap(Map<String,String> map){
        this.map=map;
    }



}
