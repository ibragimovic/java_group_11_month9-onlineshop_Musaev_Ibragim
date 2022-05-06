package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.repository.TabletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TabletService {
    private final TabletRepository tabletRepository;

}
