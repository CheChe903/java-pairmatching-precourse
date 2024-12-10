package pairmatching.utils;

import static pairmatching.utils.exception.ErrorMessage.FILE_ERROR;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.utils.exception.MatchingException;

public class FileReader {

    public static List<String> processFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            List<String> readingFileResult = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String name = line;
                readingFileResult.add(name);
            }
            return readingFileResult;
        } catch (IOException e) {
            throw new MatchingException(FILE_ERROR);
        }

    }

}
