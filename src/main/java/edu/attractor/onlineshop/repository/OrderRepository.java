package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findByCartId(Long cartId);

    Page<Order> getByCartId (Long cartId, Pageable pageable);

    boolean existsByCartId(Long cartId);

    void deleteAllByCartId(Long cartId);
}
