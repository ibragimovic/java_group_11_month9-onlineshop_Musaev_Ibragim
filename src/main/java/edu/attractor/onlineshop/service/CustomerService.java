package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.CustomerDTO;
import edu.attractor.onlineshop.dto.CustomerRegisterForm;
import edu.attractor.onlineshop.entity.Customer;
import edu.attractor.onlineshop.exception.CustomerAlreadyRegisteredException;
import edu.attractor.onlineshop.exception.CustomerNotFoundException;
import edu.attractor.onlineshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    public CustomerDTO register(CustomerRegisterForm form) {
        if (customerRepository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var customer = Customer.builder()
                .email(form.getEmail())
                .fullName(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        customerRepository.save(customer);

        return CustomerDTO.from(customer);
    }

    public CustomerDTO getByEmail (String email) {
        var customer = customerRepository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerDTO.from(customer);
    }
}
