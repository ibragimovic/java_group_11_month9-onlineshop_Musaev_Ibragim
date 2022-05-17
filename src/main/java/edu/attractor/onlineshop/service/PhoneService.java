package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.PhoneDTO;
import edu.attractor.onlineshop.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public Page<PhoneDTO> showVarietyOfPhones(Pageable pageable) {
        return phoneRepository.getAllPhones(pageable)
                .map(PhoneDTO::from);
    }

}
