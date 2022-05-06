package edu.attractor.onlineshop.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileStorage {
    String save(InputStream inputStream) throws IOException;
    InputStream get(String identity) throws FileNotFoundException;
}
