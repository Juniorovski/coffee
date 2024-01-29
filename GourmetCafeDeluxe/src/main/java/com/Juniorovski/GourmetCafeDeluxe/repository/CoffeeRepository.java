package com.Juniorovski.GourmetCafeDeluxe.repository;

import com.Juniorovski.GourmetCafeDeluxe.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
    Optional<Coffee> findAllById(Long id);
}
