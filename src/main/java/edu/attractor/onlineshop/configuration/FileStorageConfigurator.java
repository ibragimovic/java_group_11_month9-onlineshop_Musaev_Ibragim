package edu.attractor.onlineshop.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "file-storage")
public class FileStorageConfigurator {
    private String basePath;
}
