package com.neurumaru.baseball;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameUI {
    private final Scanner scanner;
    private final OutputStream outputStream;
    private final Map<String, String> stringMap;

    public GameUI(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new HashMap<>());
    }

    public GameUI(InputStream inputStream, OutputStream outputStream, Map<String, String> stringMap) {
        this.scanner = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.stringMap = stringMap;
    }

    public String getString(String tag) {
        return stringMap.get(tag);
    }
}
