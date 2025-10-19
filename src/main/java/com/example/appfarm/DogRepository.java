package com.example.appfarm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appfarm.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    // แค่นี้ก็เพียงพอแล้ว!
    // JpaRepository จะสร้างเมธอดที่จำเป็นเช่น findAll(), findById(), save(), delete() ให้เราอัตโนมัติ
}