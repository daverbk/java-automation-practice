package services;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileFromResourceUploader {
    public File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("File not found! File: " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
