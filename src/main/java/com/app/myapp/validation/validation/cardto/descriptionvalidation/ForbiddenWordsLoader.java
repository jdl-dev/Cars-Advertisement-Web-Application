package com.app.myapp.validation.validation.cardto.descriptionvalidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ForbiddenWordsLoader {

    public ForbiddenWordsLoader() {
    }

    public Set<String> loadForbiddenWords(String filename) {
        Set<String> forbiddenWords = new HashSet<>();
        try (InputStream inputStream = ForbiddenWordsLoader.class.getClassLoader().getResourceAsStream(filename)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    forbiddenWords.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return forbiddenWords;
    }
}