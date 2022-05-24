package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.LaptopDTO;
import edu.attractor.onlineshop.exception.ResourceNotFoundException;
import edu.attractor.onlineshop.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public Page<LaptopDTO> showVarietyOfLaptops(Pageable pageable) {
        return laptopRepository.getAllLaptops(pageable)
                .map(LaptopDTO::from);
    }

    public LaptopDTO getLaptopDTOByName(String name) {
        var gadget = laptopRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("phone", name));
        return LaptopDTO.from(gadget);
    }
}
