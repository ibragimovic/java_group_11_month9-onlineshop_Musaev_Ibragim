package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Laptop;
import edu.attractor.onlineshop.entity.Tablet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TabletRepository extends JpaRepository<Tablet, Integer> {

    @Query("select t from Tablet t")
    Page<Tablet> getAllTablets(Pageable pageable);

    Optional<Tablet> findById(Long commentId);

    Optional<Tablet> findByName(String gadgetName);
}
