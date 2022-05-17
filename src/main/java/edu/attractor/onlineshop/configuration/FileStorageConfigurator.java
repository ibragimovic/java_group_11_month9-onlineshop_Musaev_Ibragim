package edu.attractor.onlineshop.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "file-store")
public class FileStorageConfigurator {
    private String BasePath;

    public FileStorageConfigurator() {
        BasePath = "product_images";
    }

    public String getPath() {
        return BasePath;
    }

    public void setPath(String path) {
        this.BasePath = path;
    }
}
