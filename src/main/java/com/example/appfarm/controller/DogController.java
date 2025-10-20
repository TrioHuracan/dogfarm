package com.example.appfarm.controller;

import com.example.appfarm.model.Dog;
import com.example.appfarm.repository.DogRepository; // <-- แก้ไข import
import com.example.appfarm.service.ReportService;   // <-- แก้ไข import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class DogController {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private ReportService reportService;

    // ... (โค้ดที่เหลือถูกต้องแล้ว) ...
    @GetMapping("/")
    public String redirectToDashboard() { return "redirect:/admin/dashboard"; }
    @GetMapping("/dashboard")
    public String showDashboard(Model model) { model.addAttribute("dogs", dogRepository.findAll()); return "dashboard"; }
    @GetMapping("/add")
    public String showAddForm(Model model) { model.addAttribute("dog", new Dog()); return "add-dog"; }
    @PostMapping("/add")
    public String addDog(@ModelAttribute Dog dog) { dogRepository.save(dog); return "redirect:/admin/dashboard"; }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) { Dog dog = dogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid dog Id:" + id)); model.addAttribute("dog", dog); return "edit-dog"; }
    @PostMapping("/edit/{id}")
    public String updateDog(@PathVariable Long id, @ModelAttribute Dog dog) { dog.setId(id); dogRepository.save(dog); return "redirect:/admin/dashboard"; }
    @GetMapping("/delete/{id}")
    public String deleteDog(@PathVariable Long id) { dogRepository.deleteById(id); return "redirect:/admin/dashboard"; }
    @GetMapping("/reports")
    public String showReportsPage(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month, Model model) {
        LocalDate today = LocalDate.now();
        int currentYear = (year != null) ? year : today.getYear();
        int currentMonth = (month != null) ? month : today.getMonthValue();
        model.addAttribute("reportData", reportService.generateMonthlyReport(currentYear, currentMonth));
        model.addAttribute("selectedYear", currentYear);
        model.addAttribute("selectedMonth", currentMonth);
        return "reports";
    }
}