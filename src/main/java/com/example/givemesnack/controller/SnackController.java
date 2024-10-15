package com.example.givemesnack.controller;

import com.example.givemesnack.model.Snack;
import com.example.givemesnack.repository.SnackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snacks")
@RequiredArgsConstructor
public class SnackController {
    private final SnackRepository snackRepository;

    @GetMapping
    public ResponseEntity<List<Snack>> getSnack() {
        return ResponseEntity.ok(snackRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Snack> createSnack(@RequestBody Snack snack) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                snackRepository.save(snack)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnack(@PathVariable Long id) {
        snackRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
