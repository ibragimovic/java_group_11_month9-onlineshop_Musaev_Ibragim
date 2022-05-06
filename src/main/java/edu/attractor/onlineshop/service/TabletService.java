package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.TabletDTO;
import edu.attractor.onlineshop.repository.TabletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TabletService {
    private final TabletRepository tabletRepository;

    public ResponseEntity<Slice<TabletDTO>> showVarietyOfTablets(Pageable pageable) {
        var tablets = tabletRepository.getAllTablets(pageable);

        tablets.ifPresent(tabletSlice -> ResponseEntity.ok(tabletSlice.map(TabletDTO::from)));
        return ResponseEntity.notFound().build();
    }
}
