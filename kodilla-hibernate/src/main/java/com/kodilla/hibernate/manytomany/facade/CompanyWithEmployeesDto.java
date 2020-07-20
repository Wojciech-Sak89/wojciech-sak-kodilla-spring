package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CompanyWithEmployeesDto {
//    @Autowired
//    private CompanyDao companyDao;

    private final Company company;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyWithEmployeesDto.class);

    public CompanyWithEmployeesDto(Company company, Employee... employee) {
        this.company = company;
        this.company.getEmployees().addAll(Arrays.asList(employee));
    }

    public void saveToDatabase(CompanyDao companyDao) {
        LOGGER.info("Saving company to database: " + company.getName());
        companyDao.save(company);
    }

    public void deleteFromDatabase(CompanyDao companyDao) {
        companyDao.deleteById(getId());
    }

    private int getId() {
        return company.getId();
    }
}
