package com.twincode.cruddemo.dao;

import com.twincode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> getAll();
    Student findByLastName(String last_name);
    void update(Student updateStudent);
}
