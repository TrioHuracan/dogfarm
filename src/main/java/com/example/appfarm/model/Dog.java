package com.example.appfarm.model;

// 1. Import Annotations ที่จำเป็น
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 2. บอกว่าคลาสนี้คือ Entity ที่ตรงกับตารางในฐานข้อมูล
public class Dog {

    @Id // 3. บอกว่า field นี้คือ Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. บอกให้ฐานข้อมูลสร้าง ID ให้อัตโนมัติ
    private long id;
    private String name;
    private String breed;
    private String gender;
    private String status;

    // --- Constructors, Getters, and Setters ไม่ต้องแก้ไข ---
    public Dog() {
    }

    public Dog(long id, String name, String breed, String gender, String status) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}