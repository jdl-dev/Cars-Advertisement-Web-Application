package com.app.myapp.validation.validation.descriptionvalidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public final class ForbiddenWordsLoader {

    private static final String FILE_PATH = "forbidden_words.txt";
    private static final Set<String> forbiddenWords = new HashSet<>();

    private ForbiddenWordsLoader() {
        loadForbiddenWords();
    }

    private static void loadForbiddenWords() {
        try (InputStream inputStream = ForbiddenWordsLoader.class.getClassLoader().getResourceAsStream(FILE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                forbiddenWords.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<String> getForbiddenWords() {
        return ForbiddenWordsLoader.getForbiddenWords();
    }
}