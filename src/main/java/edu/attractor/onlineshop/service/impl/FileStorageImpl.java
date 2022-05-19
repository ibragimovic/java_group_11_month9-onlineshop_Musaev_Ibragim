package edu.attractor.onlineshop.service.impl;

import edu.attractor.onlineshop.configuration.FileStorageConfigurator;
import edu.attractor.onlineshop.service.FileStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageImpl implements FileStorage {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    private final FileStorageConfigurator fileStorageConfigurator;

    @Override
    public String save(InputStream inputStream) throws IOException {
        String key = generateKey();
        File file = new File(getFullPath(key));

        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

        return key;
    }

    @Override
    public InputStream get(String identity) throws FileNotFoundException {
        return new FileInputStream(getFullPath(identity));
    }

    private String generateKey(){
        return UUID.randomUUID().toString();
    }

    private String getFullPath(String key) {
        return String.format("%s/%s", fileStorageConfigurator.getBasePath(), key);
    }
}
