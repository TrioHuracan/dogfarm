package com.example.appfarm.controller;

import com.example.appfarm.model.Dog;
import com.example.appfarm.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // เพิ่ม PostMapping
import org.springframework.web.bind.annotation.ModelAttribute; // เพิ่ม ModelAttribute

import java.util.List;

@Controller
public class BackendController {

    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/")
    public String redirectToDashboard() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model) {
        List<Dog> dogList = dogRepository.findAll();
        model.addAttribute("dogs", dogList);
        return "dashboard";
    }

    // --- เพิ่มเข้ามาใหม่: เมธอดสำหรับแสดงหน้าฟอร์ม ---
    @GetMapping("/admin/add")
    public String showAddDogForm(Model model) {
        // สร้างอ็อบเจ็กต์ Dog เปล่าๆ เพื่อผูกกับฟอร์ม
        model.addAttribute("dog", new Dog());
        return "add-dog"; // ไปที่หน้า add-dog.html
    }

    // --- เพิ่มเข้ามาใหม่: เมธอดสำหรับรับข้อมูลจากฟอร์มและบันทึก ---
    @PostMapping("/admin/add")
    public String addDog(@ModelAttribute Dog dog) {
        // บันทึกข้อมูลสุนัขที่ได้จากฟอร์มลงฐานข้อมูล
        dogRepository.save(dog);
        return "redirect:/admin/dashboard"; // กลับไปที่หน้า dashboard
    }
    
    @GetMapping("/admin/reports")
    public String showReportsPage() {
        return "reports";
    }
}