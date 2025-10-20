package com.example.appfarm.repository; // <-- แก้ไข package

import com.example.appfarm.model.SaleRecord; // <-- แก้ไข import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRecordRepository extends JpaRepository<SaleRecord, Long> {
    List<SaleRecord> findBySaleDateBetween(LocalDate startDate, LocalDate endDate);
}