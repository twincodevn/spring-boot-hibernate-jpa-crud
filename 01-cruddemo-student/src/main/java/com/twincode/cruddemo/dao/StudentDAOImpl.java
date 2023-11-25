package com.twincode.cruddemo.dao;

import com.twincode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> sqlQuery = entityManager.createQuery("From Student",Student.class);
        return sqlQuery.getResultList();
    }

    @Override
    public Student findByLastName(String last_name) {
        TypedQuery<Student> sqlQuery = entityManager.createQuery("From Student where last_name=:data",Student.class);
        sqlQuery.setParameter("data",last_name);
        return sqlQuery.getResultList().get(0);
    }

    @Override
    @Transactional
    public void update(Student updateStudent) {
        entityManager.merge(updateStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class,id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numRowsDeleted;
    }


}
