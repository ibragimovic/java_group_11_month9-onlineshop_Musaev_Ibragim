package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.LaptopDTO;
import edu.attractor.onlineshop.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public ResponseEntity<Slice<LaptopDTO>> showVarietyOfLaptops(Pageable pageable) {
        var laptops = laptopRepository.getAllLaptops(pageable);

        laptops.ifPresent(laptopSlice -> ResponseEntity.ok(laptopSlice.map(LaptopDTO::from)));
        return ResponseEntity.notFound().build();
    }

}
