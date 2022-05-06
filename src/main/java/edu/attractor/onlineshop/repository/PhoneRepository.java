package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Phone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("select p from Phone p")
    Slice<Phone> getAllPhones(Pageable pageable);

    Optional<Phone> findById(Integer commentId);
}