package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.CustomerDTO;
import edu.attractor.onlineshop.dto.CustomerRegisterForm;
import edu.attractor.onlineshop.entity.Customer;
import edu.attractor.onlineshop.exception.CustomerAlreadyRegisteredException;
import edu.attractor.onlineshop.exception.CustomerNotFoundException;
import edu.attractor.onlineshop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public void register(CustomerRegisterForm form) {
        if (customerRepository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var customer = Customer.builder()
                .email(form.getEmail())
                .fullName(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        customerRepository.save(customer);

        CustomerDTO.from(customer);
    }

    public CustomerDTO getByEmail (String email) {
        var customer = customerRepository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerDTO.from(customer);
    }

    public Customer getByEmailCustomer (String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public void invalidateSession(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }
}
