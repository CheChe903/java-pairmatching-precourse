package pairmatching.utils;

import static pairmatching.utils.exception.ErrorMessage.FILE_ERROR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pairmatching.utils.exception.MatchingException;

public class FileReader {

    public static List<String> processFile(String filePath) {
        try (InputStream inputStream = FileReader.class.getResourceAsStream(filePath)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                List<String> readingFileResult = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    readingFileResult.add(line);
                }
                return readingFileResult;
            }
        } catch (IOException | NullPointerException e) {
            throw new MatchingException(FILE_ERROR);
        }
    }
}
