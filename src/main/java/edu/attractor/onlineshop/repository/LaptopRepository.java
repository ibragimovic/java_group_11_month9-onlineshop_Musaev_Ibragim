package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Laptop;
import edu.attractor.onlineshop.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    @Query("select l from Laptop l")
    Page<Laptop> getAllLaptops(Pageable pageable);

    Page<Laptop> findById(Long laptopId, Pageable pageable);

    Optional<Laptop> findByName(String gadgetName);

}
