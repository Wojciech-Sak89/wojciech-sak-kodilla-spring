package com.kodilla.hibernate.manytomany.dao;


import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeDaoTestSuite {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testNamedQuery_RetrieveEmployeeByLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee martaKovalsky = new Employee("Marta", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(martaKovalsky);
        int johnSmithId = johnSmith.getId();
        int stephanieClarcksonId = stephanieClarckson.getId();
        int lindaKovalskyId = lindaKovalsky.getId();
        int martaKovalskyId = martaKovalsky.getId();


        //When
        List<Employee> employeesKovalsky = employeeDao.retrieveEmployeeByLastName("Kovalsky");

        //Then
        try {
            Assert.assertEquals(2, employeesKovalsky.size());
        } finally {
            //CleanUp
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
            employeeDao.deleteById(martaKovalskyId);

        }
    }

    @Test
    public void testNamedQuery_RetrieveEmployeeByAnyFragmentOfLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee martaKovalsky = new Employee("Marta", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(martaKovalsky);
        int johnSmithId = johnSmith.getId();
        int stephanieClarcksonId = stephanieClarckson.getId();
        int lindaKovalskyId = lindaKovalsky.getId();
        int martaKovalskyId = martaKovalsky.getId();


        //When
        List<Employee> employeesKovalsky = employeeDao.retrieveEmployeeByAnyFragmentOfLastName("%val%");

        //Then
        try {
            Assert.assertEquals(2, employeesKovalsky.size());
        } finally {
            //CleanUp
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
            employeeDao.deleteById(martaKovalskyId);

        }
    }
}