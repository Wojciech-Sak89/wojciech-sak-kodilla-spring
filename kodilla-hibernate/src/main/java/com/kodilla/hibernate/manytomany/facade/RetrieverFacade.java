package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieverFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(RetrieverFacade.class);

    public List<Company> getCompanies_ByAnyFragmentOfName(String query) throws RetrievingException {
        LOGGER.info("Retrieving companies having in their name: " + query);
        List<Company> companies = companyDao.retrieveCompanies_ByAnyFragmentOfTheirName("%" + query + "%");

        if (companies.size() == 0) {
            LOGGER.error(RetrievingException.ERR_NO_COMPANIES_RESULTS);
            throw new RetrievingException(RetrievingException.ERR_NO_COMPANIES_RESULTS);
        }

        return companies;
    }

    public List<Employee> getEmployees_ByAnyFragmentOfLastName(String query) throws RetrievingException {
        LOGGER.info("Retrieving employees having in their last name: " + query);
        List<Employee> employees = employeeDao.retrieveEmployeeByAnyFragmentOfLastName("%" + query + "%");

        if (employees.size() == 0) {
            LOGGER.error(RetrievingException.ERR_NO_EMPLOYEES_RESULTS);
            throw new RetrievingException(RetrievingException.ERR_NO_EMPLOYEES_RESULTS);
        }

        return employees;
    }
}
