package com.app.myapp.validation.validation.description_validation;

import com.app.myapp.exception.other_purpose_exceptions.ForbiddenWordsLoadingException;

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
            throw new ForbiddenWordsLoadingException("Error occurs during loading forbidden words process", e);
        }

        return forbiddenWords;
    }
}