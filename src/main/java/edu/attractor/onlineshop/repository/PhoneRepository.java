package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("select p from Phone p")
    Page<Phone> getAllPhones(Pageable pageable);

    Optional<Phone> findById(Long commentId);

    Optional<Phone> findByName(String gadgetName);
}
