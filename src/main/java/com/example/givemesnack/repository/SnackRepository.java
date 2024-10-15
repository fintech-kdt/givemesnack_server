package com.example.givemesnack.repository;

import com.example.givemesnack.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SnackRepository extends JpaRepository<Snack, Long> {

    @Query(value = "SELECT * FROM snacks WHERE (IF(RAND() < 0.4, SLEEP(15), 1)) = 1", nativeQuery = true)
    List<Snack> findAllWithDelay();
}
