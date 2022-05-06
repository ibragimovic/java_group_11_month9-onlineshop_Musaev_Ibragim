package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Laptop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    @Query("select l from Laptop l")
    Optional<Slice<Laptop>> getAllLaptops(Pageable pageable);

    Optional<Laptop> findById(Integer commentId);
}
