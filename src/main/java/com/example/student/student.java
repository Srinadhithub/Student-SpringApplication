package com.example.student;
import lombok.*;
@Getter
@Setter
public class student {
    private int rollno;
    private String name;
    private int age;

    public student(int rollno, String name,int age) {
        this.rollno = rollno;
        this.name = name;
        this.age=age;
    }
}

