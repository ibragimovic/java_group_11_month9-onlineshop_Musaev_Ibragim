package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.TabletDTO;
import edu.attractor.onlineshop.exception.ResourceNotFoundException;
import edu.attractor.onlineshop.repository.TabletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TabletService {
    private final TabletRepository tabletRepository;

    public Page<TabletDTO> showVarietyOfTablets(Pageable pageable) {
        return tabletRepository.getAllTablets(pageable)
                .map(TabletDTO::from);
    }

    public TabletDTO getTabletDTOByName(String name) {
        var gadget = tabletRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("phone", name));
        return TabletDTO.from(gadget);
    }
}
