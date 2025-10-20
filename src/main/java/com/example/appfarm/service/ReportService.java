package com.example.appfarm.service; // <-- แก้ไข package

import com.example.appfarm.model.SaleRecord;
import com.example.appfarm.repository.SaleRecordRepository; // <-- แก้ไข import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private SaleRecordRepository saleRecordRepository;

    public Map<String, Object> generateMonthlyReport(int year, int month) {
        // ... (โค้ดส่วน Logic ถูกต้องแล้ว) ...
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        LocalDate prevStartDate = startDate.minusMonths(1);
        LocalDate prevEndDate = startDate.minusDays(1);
        List<SaleRecord> currentMonthSales = saleRecordRepository.findBySaleDateBetween(startDate, endDate);
        List<SaleRecord> previousMonthSales = saleRecordRepository.findBySaleDateBetween(prevStartDate, prevEndDate);
        BigDecimal currentMonthRevenue = currentMonthSales.stream().map(SaleRecord::getSalePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal previousMonthRevenue = previousMonthSales.stream().map(SaleRecord::getSalePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        int currentMonthCount = currentMonthSales.size();
        int previousMonthCount = previousMonthSales.size();
        Map<String, Object> reportData = new HashMap<>();
        reportData.put("year", year);
        reportData.put("month", month);
        reportData.put("currentMonthRevenue", currentMonthRevenue);
        reportData.put("previousMonthRevenue", previousMonthRevenue);
        reportData.put("currentMonthCount", currentMonthCount);
        reportData.put("previousMonthCount", previousMonthCount);
        reportData.put("salesList", currentMonthSales);
        return reportData;
    }
}