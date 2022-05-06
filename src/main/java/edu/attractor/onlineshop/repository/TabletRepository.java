package edu.attractor.onlineshop.repository;

import edu.attractor.onlineshop.entity.Tablet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TabletRepository extends JpaRepository<Tablet, Integer> {

    @Query("select t from Tablet t")
    Slice<Tablet> getAllTablets(Pageable pageable);

    Optional<Tablet> findById(Integer commentId);
}