package edu.attractor.onlineshop.frontend;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertiesService {
    private final SpringDataWebProperties pageableDefaultProperties;

    public int getDefaultPageSize() {
        return pageableDefaultProperties.getPageable().getDefaultPageSize();
    }
}
