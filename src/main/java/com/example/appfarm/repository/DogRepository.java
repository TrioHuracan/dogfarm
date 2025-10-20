package com.example.appfarm.repository; // <-- แก้ไข package

import com.example.appfarm.model.Dog; // <-- แก้ไข import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}