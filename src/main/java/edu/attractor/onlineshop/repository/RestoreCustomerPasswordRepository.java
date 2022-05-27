package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.RestoreCustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestoreCustomerPasswordRepository extends JpaRepository<RestoreCustomerInfo, Long> {

    Optional<RestoreCustomerInfo> findByHash(String hash);

    void deleteByHash(String hash);
}
