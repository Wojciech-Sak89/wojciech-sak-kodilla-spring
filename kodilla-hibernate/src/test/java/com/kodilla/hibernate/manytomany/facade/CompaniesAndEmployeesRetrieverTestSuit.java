package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompaniesAndEmployeesRetrieverTestSuit {
    @Autowired
    private RetrieverFacade retrieverFacade;

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testRetrieverFacade() throws RetrievingException {
        //Given
        CompanyWithEmployeesDto softwareMachine = new CompanyWithEmployeesDto(new Company("Software Machine"),
                new Employee("John", "Smith"),
                new Employee("Stephanie", "Clarckson"),
                new Employee("Linda", "Kovalsky")
        );

        CompanyWithEmployeesDto greyMatter = new CompanyWithEmployeesDto(new Company("Grey Matter"),
                new Employee("Martin", "Seligman"),
                new Employee("Donald", "Clarckson"),
                new Employee("Bram", "Stoker")
        );

        CompanyWithEmployeesDto softwareMaesters = new CompanyWithEmployeesDto(new Company("Software Maesters"),
                new Employee("Peter", "Straub"),
                new Employee("Dan", "Simmons"),
                new Employee("Gaston", "Loroux")
        );

        softwareMachine.saveToDatabase(companyDao);
        greyMatter.saveToDatabase(companyDao);
        softwareMaesters.saveToDatabase(companyDao);

        //When
        List<Employee> employeesLarck = retrieverFacade.getEmployees_ByAnyFragmentOfLastName("larck");
        List<Employee> employeesOux = retrieverFacade.getEmployees_ByAnyFragmentOfLastName("oux");
        List<Company> companiesOftw = retrieverFacade.getCompanies_ByAnyFragmentOfName("oftw");
        List<Company> companiesTter = retrieverFacade.getCompanies_ByAnyFragmentOfName("tter");

        //Then
        Assert.assertEquals(2, employeesLarck.size());
        Assert.assertEquals(1, employeesOux.size());
        Assert.assertEquals(2, companiesOftw.size());
        Assert.assertEquals(1, companiesTter.size());

        //CleanUp
        try {
            softwareMachine.deleteFromDatabase(companyDao);
            greyMatter.deleteFromDatabase(companyDao);
            softwareMaesters.deleteFromDatabase(companyDao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
