package com.example.givemesnack.repository;

import com.example.givemesnack.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SnackRepository extends JpaRepository<Snack, Long> {

    @Query(value = "SELECT * FROM snacks WHERE (RAND() < 0.3 AND SLEEP(5)) OR 1", nativeQuery = true)
    List<Snack> findAllWithDelay();
}
