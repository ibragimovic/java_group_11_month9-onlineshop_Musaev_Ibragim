package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.repository.LaptopRepository;
import edu.attractor.onlineshop.repository.PhoneRepository;
import edu.attractor.onlineshop.repository.TabletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GadgetService {
    private final LaptopRepository laptopRepository;
    private final TabletRepository tabletRepository;
    private final PhoneRepository phoneRepository;

//    public Page<GadgetDTO> showVarietyOfPhones(Pageable pageable) {
//        Page<GadgetDTO> gadgets = new ArrayList<>();
//        var laptops = new ArrayList<>(laptopRepository.getAllLaptops(pageable)
//                .map(LaptopDTO::from)
//                .getContent()).;
//        var tablets = tabletRepository.getAllTablets(pageable)
//                .map(TabletDTO::from)
//                .getContent();
//        gadgets.addAll(tablets);
//        var phones = phoneRepository.getAllPhones(pageable)
//                .map(PhoneDTO::from)
//                .getContent();
//        gadgets.addAll(gadgets);
//
//
//
//    }

}
