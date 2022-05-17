package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.TabletDTO;
import edu.attractor.onlineshop.repository.TabletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TabletService {
    private final TabletRepository tabletRepository;

    public Page<TabletDTO> showVarietyOfTablets(Pageable pageable) {
        return tabletRepository.getAllTablets(pageable)
                .map(TabletDTO::from);
    }
}
