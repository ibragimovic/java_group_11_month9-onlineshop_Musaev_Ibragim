package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCustomerId(Long customerId);

    boolean existsByCustomerId(Long customerId);
}
