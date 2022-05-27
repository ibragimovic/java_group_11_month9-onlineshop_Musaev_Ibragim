package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.entity.Customer;
import edu.attractor.onlineshop.entity.RestoreCustomerInfo;
import edu.attractor.onlineshop.exception.CustomerNotFoundException;
import edu.attractor.onlineshop.repository.RestoreCustomerPasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestorePasswordService {
    private final CustomerService customerService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RestoreCustomerPasswordRepository restoreCustomerPasswordRepository;

    public String restorePassword(String email) {
        Customer customer = customerService.getByEmailCustomer(email);

        String hash = generateRandomLink(customer);

        customer.setPassword(passwordEncoder.encode(hash));
        customerService.save(customer);
        //emailSender.sendLinkToEmail(link);
        return hash;
    }

    private String generateRandomLink(Customer customer){
        String uuid = UUID.randomUUID().toString();
        RestoreCustomerInfo restoreCustomerInfo =  RestoreCustomerInfo.builder()
                .email(customer.getEmail())
                .hash(uuid)
                .build();
        restoreCustomerPasswordRepository.save(restoreCustomerInfo);
        return uuid;
    }

    public void updatePassword(HttpServletRequest req, String hash) {
        Customer customer = getCustomerByHash(hash);
        restoreCustomerPasswordRepository.deleteByHash(hash);

        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(customer.getEmail(), hash);
        Authentication auth = authenticationManager.authenticate(authReq);

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = req.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
    }

    private Customer getCustomerByHash(String hash) {
        RestoreCustomerInfo restoreCustomerInfo = restoreCustomerPasswordRepository.findByHash(hash)
                .orElseThrow(CustomerNotFoundException::new);
        restoreCustomerPasswordRepository.delete(restoreCustomerInfo);
        return customerService.getByEmailCustomer(restoreCustomerInfo.getEmail());
    }
}
